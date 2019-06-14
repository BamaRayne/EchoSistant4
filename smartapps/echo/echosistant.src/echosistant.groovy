/* 
 * EchoSistant v5.0 control and Feedback of your Smart Things Environment via Natural Conversations with Alexa.
 
 
 ************************************ FOR INTERNAL USE ONLY ******************************************************
							
 								DON'T FORGET TO UPDATE RELEASE NUMBER!!!!!
 
************************************ FOR INTERNAL USE ONLY ******************************************************
*
*		06/17/2019	Version: 5.0 R.0.0.5	Bug fix in LARN
*		06/04/2019	Version: 5.0 R.0.0.4	Changed Lambda ARN from typing in app to adding to app settings in the API (easier to install) and it is backwards compatible
*		04/13/2019	Version: 5.0 R.0.0.3	Added toggle to activate weather alerts checks every 15 minutes
*		01/13/2019	Version: 5.0 R.0.0.2	Added ability to have multi room commands (turn on lights in living room and turn on lights in kitchen)
*     	01/12/2019	Version: 5.0 R.0.0.1c	License update/change
* 		01/12/2019	Version: 5.0 R.0.0.1b	Bug fix for Android/IOS selection
*		01/11/2019	Version: 5.0 R.0.0.1a	Change to room names. Multi word room names no longer need to be one word (LivingRoom can now be Living Room)
*		01/11/2019	Version: 5.0 R.0.0.1	Major version update ~ addition of automatically deployed AWS skills
*		12/23/2018	Version: 4.6 R.0.0.4	Code clean up
*		12/21/2018	Version: 4.6 R.0.0.3	UI Changes and bug fix in WebCoRE Piston execution	
*		12/18/2018 	Version: 4.6 R.0.0.2e	Bug fix in SHM announcements and addition of optional restore volume on Alexa Devices, UI updates	
*		12/18/2018 	Version: 4.6 R.0.0.2d	Bug fix
*		12/16/2018 	Version: 4.6 R.0.0.2C	Addidtion of system defaults page
*		12/06/2018 	Version: 4.6 R.0.0.2b	Small changes and updates
*		12/01/2018 	Version: 4.6 R.0.0.2a	Moved donations to opening page
*		11/27/2018 	Version: 4.6 R.0.0.2	Bug fix in ST token generation and code clean up
*		11/23/2018 	Version: 4.6 R.0.0.1	Version change and release
*		10/26/2018 	Version: 4.5 R.0.0.2	Re-Release
*
*  Based upon the previous collective works of the EchoSistant Team of Versions 1-4.
*  Copyright 2019 Jason Headley
*
*  This software if free for Private Use. You may use this software in its entirety and may not modify, adjust, rewrite,
*  borrow from, or utilize the software in any other means not specifically specified by the original author.
*  
*  This software and derivatives may not be used for commercial purposes.
*  You may not distribute or sublicense this software.
*  You may not grant a sublicense to modify and distribute this software to third parties not included in the license.
*  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
*  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
*  for the specific language governing permissions and limitations under the License.
*
*
/**********************************************************************************************************************************************/
import groovy.json.*
import java.text.SimpleDateFormat
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import java.security.InvalidKeyException
import java.security.MessageDigest

include 'asynchttp_v1'

private getLarn()		{ appSettings.LambdaArn }

definition(
	name			: "EchoSistant",
    namespace		: "Echo",
    author			: "JH/BD",
	description		: "Control and Feedback of your Smart Things Environment via Natural Conversations with Alexa.",
	category		: "My Apps",
    singleInstance	: true,
	iconUrl			: "https://raw.githubusercontent.com/BamaRayne/Echosistant/master/smartapps/bamarayne/echosistant.src/app-Echosistant.png",
	iconX2Url		: "https://raw.githubusercontent.com/BamaRayne/Echosistant/master/smartapps/bamarayne/echosistant.src/app-Echosistant@2x.png",
	iconX3Url		: "https://raw.githubusercontent.com/BamaRayne/Echosistant/master/smartapps/bamarayne/echosistant.src/app-Echosistant@2x.png")
{

	appSetting "LambdaArn"

}
/**********************************************************************************************************************************************
	UPDATE LINE 38 TO MATCH RECENT RELEASE
**********************************************************************************************************************************************/
private def textVersion() {
	def text = "1.0"
}
private release() {
    def text = "Version 5.0, Revision 0.0.5"
}
/**********************************************************************************************************************************************/
preferences {   
    page name: "mainParentPage"
    page name: "mIntent"				
    page name: "mProfiles" 
    page name: "mSupport"
    page name: "mSettings"
    page name: "mTokens"
    page name: "mConfirmation"            
    page name: "mTokenReset"
    page name: "mBonus"
    page name: "mDashboard"
    page name: "spellings"
    page name: "mDefaults"
    page name: "awsSkillConfigPage"
    page name: "awsSkillAuthGenPage"
    page name: "manageProfilesPage"
    page name: "processActionsPage"
    page name: "codeUpdatesPage"
   

}

//dynamic page methods
page name: "mainParentPage"
def mainParentPage() {	
    dynamicPage(name: "mainParentPage", title:"", install: true, uninstall:false) {
        section ("") {
            href "mProfiles", title: "Create and Manage Rooms", description: mRoomsD(), state: mRoomsS(),
            image: "https://raw.githubusercontent.com/BamaRayne/Echosistant/master/smartapps/bamarayne/echosistant.src/Echosistant_Routines.png"
        }
        section ("") {
        	href "awsSkillConfigPage", title: "Create and Manage AWS Rooms Skills", description: mSkillD(), state: mSkillS(),
            image: "https://raw.githubusercontent.com/BamaRayne/EchoSistant4/master/Icons/Skills.png"
            }
        section ("") {
            href "mIntent", title: "Configure System Settings", description: mIntentD(), state: mIntentS(), 
            image: "https://raw.githubusercontent.com/BamaRayne/Echosistant/master/smartapps/bamarayne/echosistant.src/Echosistant_Config.png"
        }
        section ("DashBoard") {
        	paragraph "The Current Mode is: ${location.currentMode}"
            paragraph "Smart Home Monitor is set to: " + getSHMStatus()
        }
        section("Donations:") {
             href url: textDonateLink(), style:"external", required: false, title:"Donations", description: mDonationsD(), state: mDonationsS(),
             image: "https://raw.githubusercontent.com/BamaRayne/SmartSuite/master/Icons/Donate.png"
        }
        section("Uninstall") {
        	href "appUninstallPage", title: "Click here to remove $app.label", description: mDeleteD(), state: mDeleteS(),
            image:"https://raw.githubusercontent.com/jasonrwise77/My-SmartThings/master/LogicRulz%20Icons/uninstall.png"
        }
	}
}

// UNINSTALL PAGE
page name: "appUninstallPage"
    def appUninstallPage() {
    	dynamicPage (name: "appUninstallPage", title: "Clicking on the BIG RED BUTTON below will completely remove $app.label and all Routines!", install: true, uninstall: true) {
    		section("Please ensure you are ready to take this step, there is no coming back from the brink!"){
            }
		}
    }    

page name: "mIntent"
def mIntent() {
    dynamicPage (name: "mIntent", title: "Settings and Support", install: false, uninstall: false) {
  //      section() {
  //      	href "codeUpdatesPage", title: "Configure updates notifications"
  //          }
        section() {
        	href "spellings", title: "Do you have family members with names spelled a little differently?", description: spellingsD(), state: spellingsS(),
            image: "https://raw.githubusercontent.com/BamaRayne/EchoSistant4/master/Icons/Strange.png"
            }
        section ("") {
            href "mSecurity", title: "Smart Home Monitor Status Changes", description: mSecurityD(), state: mSecurityS(),
            image: "https://raw.githubusercontent.com/BamaRayne/EchoSistant4/master/Icons/SHM_Monitor.png"
        }
        section ("") {
            href "mSupport", title: "Install and Support Information", description: mSupportD(), state: mSupportS(),
            image: "https://raw.githubusercontent.com/BamaRayne/EchoSistant4/master/Icons/Install_Support.png"
        }
        section ("") {
            href "mDefaults", title: "System and Device Control Defaults", description: mDefaultsD(), state: mDefaultsS(),
            image: "https://raw.githubusercontent.com/BamaRayne/EchoSistant4/master/Icons/Default.png"
		}
    }
}

page name: "mSecurity"    
def mSecurity(){
    dynamicPage(name: "mSecurity", title: "",install: false, uninstall: false) {
		section ("Smart Home Monitor Status Change Feedback",hideable: true){
            input "fSecFeed", "bool", title: "Activate SHM status change announcements.", default: false, submitOnChange: true
            }
            if (fSecFeed) {
        section ("Alexa Devices") {    
        	input "shmEchoDevice", "device.echoSpeaksDevice", title: "Announce Changes on these Amazon Alexa Devices", multiple: true, required: false, submitOnChange: true
            	if (shmEchoDevice) {
                input "eVolume", "number", title: "Set the volume", description: "0-100 (default value = 30)", required: false, defaultValue: 30, submitOnChange: true
            	input "svr", "bool", title: "Do you want to restore the volume to preannouncement levels?", required: false, default:faluse, submitOnChange: true
                if (svr) {
                	input "restoreVol", "number", title: "Restore volume to this level (default is 30%)", required: false, defaultValue: 30, submitOnChange: true
                    }
				}
            }
        section ("Other Audio Devices") {            
                input "shmSynthDevice", "capability.speechSynthesis", title: "Announce Changes On these Speech Synthesis Type Devices", multiple: true, required: false
                input "shmSonosDevice", "capability.musicPlayer", title: "Announce Changes On these Sonos Type Devices", required: false, multiple: true, submitOnChange: true    
            
            if (shmSonosDevice) {
                input "volume", "number", title: "Temporarily change volume", description: "0-100%", required: false, defaultValue: 30
            	}
            }
        section ("Smart Message Control") {    
            if (fSecFeed) {
            	input "shmSmc", "bool", title: "Announce via Smart Message Control App", default: false, submitOnChange: true
            	}
            }
        }
    }
}

page name: "mDefaults"
def mDefaults(){
    dynamicPage(name: "mDefaults", title: "", uninstall: false){
        section ("General Control") {            
            input "cLevel", "number", title: "Alexa Adjusts Light Levels by using a scale of 1-10 (default is +/-3)", defaultValue: 3, required: false
            input "cVolLevel", "number", title: "Alexa Adjusts the Volume Level by using a scale of 1-10 (default is +/-2)", defaultValue: 2, required: false
//            input "cTemperature", "number", title: "Alexa Automatically Adjusts temperature by using a scale of 1-10 (default is +/-1)", defaultValue: 1, required: false						
        }
        section ("Fan Control") {            
            input "cHigh", "number", title: "Alexa Adjusts High Level to 99% by default", defaultValue: 99, required: false
            input "cMedium", "number", title: "Alexa Adjusts Medium Level to 66% by default", defaultValue: 66, required: false
            input "cLow", "number", title: "Alexa Adjusts Low Level to 33% by default", defaultValue: 33, required: false
            input "cFanLevel", "number", title: "Alexa Automatically Adjusts Ceiling Fans by using a scale of 1-100 (default is +/-33%)", defaultValue: 33, required: false
        }
       section ("Alexa Voice Settings") {            
            input "pDisableContCmds", "bool", title: "Disable Conversation (Alexa no longer prompts for additional commands except for 'try again' if an error ocurs)?", required: false, defaultValue: false
            input "pEnableMuteAlexa", "bool", title: "Disable Feedback (Silence Alexa - it no longer provides any responses)?", required: false, defaultValue: false
            input "pUseShort", "bool", title: "Use Short Alexa Answers (Alexa provides quick answers)?", required: false, defaultValue: false
        }
 /*       section ("HVAC Filters Replacement Reminders", hideWhenEmpty: true, hideable: true, hidden: false) {
            input "cFilterReplacement", "number", title: "Alexa Automatically Schedules HVAC Filter Replacement in this number of days (default is 90 days)", defaultValue: 90, required: false                        
            input "cFilterSynthDevice", "capability.speechSynthesis", title: "Send Audio Notification when due, to this Speech Synthesis Type Device(s)", multiple: true, required: false
            input "cFilterSonosDevice", "capability.musicPlayer", title: "Send Audio Notification when due, to this Sonos Type Device(s)", required: false, multiple: true   
            if (cFilterSonosDevice) {
                input "volume", "number", title: "Temporarily change volume", description: "0-100%", required: false
            }
            if (location.contactBookEnabled){
                input "recipients", "contact", title: "Send Text Notification when due, to this recipient(s) ", multiple: true, required: false
            }
            else {      
                input name: "sms", title: "Send Text Notification when due, to this phone(s) ", type: "phone", required: false
                paragraph "You may enter multiple phone numbers separated by comma (E.G. 8045551122,8046663344)"
                input "push", "bool", title: "Send Push Notification too?", required: false, defaultValue: false
            }
        }*/
            //href "mWeatherConfig", title: "Tap here to configure the Weather defaults", description: "", state: complete
        }                     
//    }
}
page name: "mProfiles"    
def mProfiles() {
    dynamicPage (name: "mProfiles", title: "Create and Manage Rooms", install: false, uninstall: false) {
        if (childApps?.size()>0) {  
            section("",  uninstall: false){
                app(name: "EchoSistant Rooms", appName: "EchoSistant Rooms", namespace: "Echo", title: "Create a New Room", displayChildApps: false, multiple: true,  uninstall: false)
            }
        }
        else {
            section("",  uninstall: false){
                paragraph "NOTE: Looks like you haven't created any Rooms yet.\n \nPlease make sure you have installed the EchoSistant Rooms Add-on before creating a new Profile!"
                app(name: "EchoSistant Rooms", appName: "EchoSistant Rooms", namespace: "Echo", title: "Create a New Room", multiple: true,  uninstall: false)
            }
        }
    }
}  

page name: "mSettings"  
def mSettings(){
    dynamicPage(name: "mSettings", uninstall: false) {
        section("") {
            input "debug", "bool", title: "Enable Debug Logging", default: true, submitOnChange: true 
        	input "trace", "bool", title: "Enable Trace Logging", default: true, submitOnChange: true
        }
        section (""){
            input "ShowLicense", "bool", title: "Show Apache License", default: false, submitOnChange: true
            def msg = textLicense()
            if (ShowLicense) paragraph "${msg}"
        }
        section ("Security Tokens", hideable: true, hidden: true) {
        	log.info "The information below is required to be copy and pasted into the AWS Lambda file. \n" +
    				"\n---------------------------------------------------------------------------------------\n" +
                    "\nvar STappID = '${app.id}' ; \n var STtoken = '${state.accessToken}' ;\n" +
                   	"\nvar url= '${apiServerUrl("/api/smartapps/installations/")}' + STappID + '/' ;' ;\n" +
                    //var url= 'https://graph-na02-useast1.api.smartthings.com:443/api/smartapps/installations/")}' + STappID + '/' ;' ;\n" +
                    
                    "\n---------------------------------------------------------------------------------------"
            paragraph "The information below is required to be copy and pasted into the AWS Lambda file. \n" +
                "------------------------------------------------------------------------------------------------------------------------------------\n" +
                " var SmartThings Token = '${state.accessToken}' ; ' ; '\n" +
                " var url= '${apiServerUrl("/api/smartapps/installations/")}' + STappID + '/' ;\n" +
                "------------------------------------------------------------------------------------------------------------------------------------" 
            href "mTokens", title: "Revoke/Reset Security Access Token", description: "Tap here to Perform the actions"
        }
    }             
}

page name: "mTokens"
def mTokens(){
    dynamicPage(name: "mTokens", title: "Security Tokens", uninstall: false){
        section(""){
            paragraph "Tap below to Reset/Renew the Security Token. You must log in to the IDE and open the Live Logs tab before tapping here. "+
                "Copy and paste the displayed tokens into your Amazon Lambda Code."
            if (!state.accessToken) {
                OAuthToken()
                paragraph "You must enable OAuth via the IDE to setup this app"
            }
        }
        def msg = state.accessToken != null ? state.accessToken : "Could not create Access Token. "+
            "OAuth may not be enabled. Go to the SmartApp IDE settings to enable OAuth."
        section ("Reset Access Token / Application ID"){
            href "mTokenReset", title: "Reset/Renew Access Token", description: "Tap here to confirm action - READ WARNING BELOW"
            paragraph "PLEASE CONFIRM! By resetting the access token you will disable the ability to interface this SmartApp with your Amazon Echo."+
                "You will need to copy the new access token to your Amazon Lambda code to re-enable access." +
                "Tap below to go back to the main menu with out resetting the token. You may also tap Done above."
        }
        section(" "){
            href "mainParentPage", title: "Cancel And Go Back To Main Menu", description: none 
        	}
        }
    }
 
page name: "mTokenReset"
def mTokenReset(){
    dynamicPage(name: "mTokenReset", title: "Access Token Reset", uninstall: false){
        section{
            state.accessToken = null
            OAuthToken()
            def msg = state.accessToken != null ? "New access token:\n${state.accessToken}\n\n" : "Could not reset Access Token."+
                "OAuth may not be enabled. Go to the SmartApp IDE settings to enable OAuth."
            paragraph "${msg}"
            paragraph "The new access token and app ID are now displayed in the Live Logs tab of the IDE. Tap SAVE/DONE now."
            log.info "New IDs: appID = '${app.id}' , Ttoken = '${state.accessToken}'"
        }
        section(" "){ 
            href "mainParentPage", title: "Tap Here To Go Back To Main Menu", description: none 
        }
    }
}

page name: "spellings"
def spellings(){
    dynamicPage(name: "spellings", uninstall: false) {
        section ("") {
            paragraph "This section is to help you take care of those names that are spelled a little differently "+
                "Such as, your name is spelled Kristopher instead of Christopher." +
                "Alexa likes things spelled a certain way, so just fill in the information below and we will take care of it for you"
        }
        section ("Your 1st Anomoly") {
            input "name1", "text", title: "How do you spell it?", required: false, default: "", submitOnChange: true
            input "name2", "text", title: "How does Alexa spell it? Check the logs", required: false, default: "", submitOnChange: true
        }
        section ("Your 2nd Anomoly") {
            input "name3", "text", title: "How do you spell it?", required: false, default: "", submitOnChange: true
            input "name4", "text", title: "How does Alexa spell it? Check the logs", required: false, default: "", submitOnChange: true
        }
        section ("Your 3rd Anamoly") {
            input "name5", "text", title: "How do you spell it?", required: false, default: "", submitOnChange: true
            input "name6", "text", title: "How does Alexa spell it? Check the logs", required: false, default: "", submitOnChange: true
        }        
    }
}


page name: "mSupport"  
def mSupport(){
    dynamicPage(name: "mSupport", uninstall: false) {
        section ("") {
            href "mSettings", title: "Security Token, Logging, App Uninstall", description: mSettingsD(), state: mSettingsS()
        }
        section ("") { 
            href url:"http://thingsthataresmart.wiki/index.php?title=EchoSistant", title: "Tap to go to the EchoSistant Wiki", description: "", state: "complete"
        }   
        section ("") {
            href url:"https://aws.amazon.com/lambda/", title: "Tap to go to the AWS Lambda Website", description: "", state: "complete"
        }
        section ("") {    
            href url:"https://developer.amazon.com/", title: "Tap to go to Amazon Developer website", description: "", state: "complete"
        }
        section (""){  
            paragraph ("You can reach out to the Echosistant Developers with the following information: \n" + 
                       "Jason Headley \n"+
                       "Forum user name @bamarayne \n" +
                       "Bobby Dobrescu \n"+
                       "Forum user name @SBDobrescu")
        }
    }	            	
}   

/*************************************************************************************************************
   CREATE INITIAL TOKEN
************************************************************************************************************/
def OAuthToken(){
	try {
		createAccessToken()
		log.debug "Creating new Access Token"
	} catch (e) {
		log.error "Access Token not defined. OAuth may not be enabled. Go to the SmartApp IDE settings to enable OAuth."
	}
}

/*************************************************************************************************************
   LAMBDA DATA MAPPING
************************************************************************************************************/
/*mappings {
    path("/b") { action: [GET: "processBegin"]}
	path("/t") { action: [GET: "processTts"] }
    path("/renderAwsCopyText") { action: [GET: "renderAwsCopyText"] }
    }*/

/*************************************************************************************************************
   LAMBDA DATA MAPPING
************************************************************************************************************/
mappings {
	path("/cntrlList") {action: [GET: "controlList"]}	
    path("/devList") {action: [GET: "deviceList"]}
    path("/b") { action: [GET: "processBegin"] }
	path("/c") { action: [GET: "controlDevices"] }
	path("/f") { action: [GET: "feedbackHandler"] }
	path("/r") { action: [GET: "remindersHandler"] }
	path("/s") { action: [GET: "controlSecurity"] }
	path("/t") { action: [GET: "processTts"] }
}

/************************************************************************************************************
		Base Process
************************************************************************************************************/
def textDonateLink() { "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=HETW6WY6T2FSL&source=url" }
def installed() {
	if (debug) log.debug "Installed with settings: ${settings} "
    state.ParentRelease = release()
    //Reminders
    state.esEvent = [:]
}
def updated() {
	
	log.warn "-->  Parent App Version: " + release()
    log.warn "-->  Child App Version: $state.childRevision"
    if (debug) log.debug "Updated with settings: ${settings}"
//    log.debug "AlexaJSON = ${atomicState.alexaJSON}"
//    log.debug "Alexa Devices = ${atomicState.alexaJSON.devices.accountName}"

//    def alexaJSON = null
//    def deviceID = null
 //   def finalList = null
    
//    alexaJSON = "${atomicState.alexaJSON.devices.deviceAccountId}".split(",").each { deviceName ->
//    	log.trace "alexaDeviceName is: $deviceName"
        
//    deviceID = "${atomicState.alexaJSON.devices.deviceAccountId}".split(",").each { finalList ->
//        log.trace "Alexa Device is: ${deviceName} : ${finalList}"
//        }
//        }

//log.debug "alexaJSON = $state.alexaJSON" //deviceAccountId  .accountName  atomicState.alexaJSON.devices.deviceAccountId


	unsubscribe()
    state.esEvent = [:]
    initialize()
}
def initialize() {
//    getAwsRegion()
		state.childRevision = null
//	state.cookie = getCookie1()
        state.alexa = null
	    state.amazon = null
    	state.language = null
		webCoRE_init()
        //REMINDERS
		sendLocationEvent(name: "EchoSistant v4.5", value: "refresh", data: [profiles: getProfileList()] , isStateChange: true, descriptionText: "Reminders list refresh")
		//SHM status change and keypad initialize
//    		subscribe(location, locationHandler)
            subscribe(location, "alarmSystemStatus",alarmStatusHandler) //used for ES speaker feedback
            state.esProfiles = state.esProfiles ? state.esProfiles : []

			state.lambdaReleaseTxt = "Not Set"
            state.lambdaReleaseDt = "Not Set" 
            state.lambdatextVersion = "Not Set"
        //Alexa Responses
			state.pTryAgain = false
        	state.pContCmds = settings.pDisableContCmds == false ? true : settings.pDisableContCmds == true ? false : true
            state.pMuteAlexa = settings.pEnableMuteAlexa
			state.pShort = settings.pUseShort
            state.pContCmdsR = "init"       
        //Other Settings
            state.lastAction = null
			state.lastActivity = null
			state.pendingConfirmation = true
}
/*def getProfileList(){
		return getChildApps()*.label
}*/


/************************************************************************************************************
		Begining Process - Lambda via page b
************************************************************************************************************/
def processBegin(){ 
	state.deviceId = params.deviceId
    def versionTxt  = params.versionTxt 		
    def versionDate = params.versionDate
    def releaseTxt = params.releaseTxt
    def event = params.intentResp
    state.event = params.intentResp
        state.lambdaReleaseTxt = releaseTxt
        state.lambdaReleaseDt = versionDate
        state.lambdatextVersion = versionTxt
    def versionSTtxt = textVersion()
    def releaseSTtxt = release()
    def pPendingAns = light 
    def pContinue = state.pMuteAlexa
    def pShort = state.pShort
    def String outputTxt = (String) null 
    	state.pTryAgain = false
    if (debug) log.debug "^^^^____LAUNCH REQUEST___^^^^" 
    if (debug) log.debug "Launch Data: (event) = '${event}', (Lambda version) = '${versionTxt}', (Lambda release) = '${releaseTxt}', (ST Main App release) = '${releaseSTtxt}'"

    if (event == "noAction") {
    	state.pinTry = null
        state.savedPINdata = null
        state.pContCmdsR = null 
        state.pTryAgain = false
}

//log.debug "deviceID = $state.deviceId"

// >>> NO Intent <<<<    
    if (event == "AMAZON.NoIntent"){
    	if(state.pContCmdsR == "level" || state.pContCmdsR == "repeat"){
            if (state.lastAction != null) {
            	if (state.pContCmdsR == "level") {state.pContCmdsR = "repeat"}
                def savedData = state.lastAction
                outputTxt = controlHandler(savedData) 
                pPendingAns = "level"
            }
            else {
                state.pContCmdsR = null
                pPendingAns = null
            }
        }
        if( state.pContCmdsR == "door"){
            if (state.lastAction != null) {
                state.lastAction = null
                state.pContCmdsR = null 
                pPendingAns = null 
            }
        }
        if( state.pContCmdsR == "feedback" ||  state.pContCmdsR == "bat" || state.pContCmdsR == "act" ){
            if (state.lastAction != null) {
                state.lastAction = null
                state.pContCmdsR = null 
                pPendingAns = null 
            }
        }
        if( state.pContCmdsR == "init" || state.pContCmdsR == "undefined"){
        	state.pTryAgain = false
        }
        if( state.pContCmdsR == null){
        	state.pTryAgain = false
        }
    }
// >>> YES Intent <<<<     
    if (event == "AMAZON.YesIntent") {
        if (state.pContCmdsR == "level" || state.pContCmdsR == "repeat") {
            state.pContCmdsR = null
            state.lastAction = null
            pPendingAns = "level"
        }
        else {
        	state.pTryAgain = false
        }
        if(state.pContCmdsR == "door"){
            if (state.lastAction != null) {
                def savedData = state.lastAction
 				//NEW PIN VALIDATION!!!!! ///// ADD THE THE usePIN variable below to run the PIN VALIDATION
 				if(state.usePIN_D == true) {
     				//RUN PIN VALIDATION PROCESS
                	def pin = "undefined"
               		def command = "validation"
                	def num = 0
                	def unit = "doors"
                	outputTxt = pinHandler(pin, command, num, unit)
                    pPendingAns = "pin"
                    if (state.pinTry == 3) {pPendingAns = "undefined"}
                    log.warn "try# ='${state.pinTry}'"
					return ["outputTxt":outputTxt, "pContinue":pContinue, "pShort":pShort, "pPendingAns":pPendingAns, "versionSTtxt":versionSTtxt]
            	}
                else {
                outputTxt = controlHandler(savedData) 
                pPendingAns = "door"
            	}
              return ["outputTxt":outputTxt, "pContinue":pContinue,  "pShort":pShort, "pPendingAns":pPendingAns, "versionSTtxt":versionSTtxt]
        	}
        }
        if(state.pContCmdsR == "feedback"){
            if (state.lastAction != null) {
                def savedData = state.lastAction
                outputTxt = getMoreFeedback(savedData) 
                pPendingAns = "feedback"
				return ["outputTxt":outputTxt, "pContinue":pContinue,  "pShort":pShort, "pPendingAns":pPendingAns, "versionSTtxt":versionSTtxt]
            }
         }
        //if Alexa is muted from the child, then mute the parent too / MOVED HERE ON 2/9/17
        pContinue = pContinue == true ? true : state.pMuteAlexa == true ? true : pContinue
		return ["outputTxt":outputTxt, "pContinue":pContinue, "pShort":pShort, "pPendingAns":pPendingAns, "versionSTtxt":versionSTtxt]	     
	}
	if (debug){
    	log.debug "Begining Process data: (device) = '${deviceId}', (event) = '${event}', (ver) = '${versionTxt}', (date) = '${versionDate}', (release) = '${releaseTxt}'"+ 
      	"; data sent: pContinue = '${pContinue}', pShort = '${pShort}',  pPendingAns = '${pPendingAns}', versionSTtxt = '${versionSTtxt}', releaseSTtxt = '${releaseSTtxt}' outputTxt = '${outputTxt}' ; "+
        "other data: pContCmdsR = '${state.pContCmdsR}', pinTry'=${state.pinTry}' "
	}
    return ["outputTxt":outputTxt, "pContinue":pContinue, "pShort":pShort, "pPendingAns":pPendingAns, "versionSTtxt":versionSTtxt]	 

} 
/************************************************************************************************************
   WEBCORE INTEGRATION
************************************************************************************************************/
private webCoRE_handle(){return'webCoRE'}
private webCoRE_init(pistonExecutedCbk){atomicState.webCoRE=(atomicState?.webCoRE instanceof Map?atomicState?.webCoRE:[:])+(pistonExecutedCbk?[cbk:pistonExecutedCbk]:[:]);subscribe(location,"${webCoRE_handle()}.pistonList",webCoRE_handler);if(pistonExecutedCbk)subscribe(location,"${webCoRE_handle()}.pistonExecuted",webCoRE_handler);webCoRE_poll();}
private webCoRE_poll(){sendLocationEvent([name: webCoRE_handle(),value:'poll',isStateChange:true,displayed:false])}
public  webCoRE_execute(pistonIdOrName,Map data=[:]){def i=(atomicState?.webCoRE?.pistons?:[]).find{(it.name==pistonIdOrName)||(it.id==pistonIdOrName)}?.id;if(i){sendLocationEvent([name:i,value:app.label,isStateChange:true,displayed:false,data:data])}}
public  webCoRE_list(mode){def p=atomicState?.webCoRE?.pistons;if(p)p.collect{mode=='id'?it.id:(mode=='name'?it.name:[id:it.id,name:it.name])}}
public  webCoRE_handler(evt){switch(evt.value){case 'pistonList':List p=atomicState?.webCoRE?.pistons?:[];Map d=evt.jsonData?:[:];if(d.id&&d.pistons&&(d.pistons instanceof List)){p.removeAll{it.iid==d.id};p+=d.pistons.collect{[iid:d.id]+it}.sort{it.name};atomicState?.webCoRE = [updated:now(),pistons:p];};break;case 'pistonExecuted':def cbk=atomicState?.webCoRE?.cbk;if(cbk&&evt.jsonData)"$cbk"(evt.jsonData);break;}}

/************************************************************************************************************
   Get current SHM status for Dashboard
************************************************************************************************************/
def getSHMStatus() {
    def currentSHM = location.currentState("alarmSystemStatus")?.value
    if (currentSHM == "off") {
        currentSHM = "Security Disabled" }
    if (currentSHM == "away") {
        currentSHM = "Armed-Away" }
    if (currentSHM == "stay") {
        currentSHM = "Armed-Stay" }
    return currentSHM
}       
             
/************************************************************************************************************
   TEXT TO SPEECH PROCESS - Lambda via page t
************************************************************************************************************/
def processTts(tts) {
		//LAMBDA VARIABLES
        log.info "event is $params.event received text is: $params.ttstext"
    	def ptts = params.ttstext 
        def pintentName = params.intentName
        //OTHER VARIABLES
        def String outputTxt = (String) null 
 		def String pContCmdsR = (String) null
        def pContCmds = false
        def pTryAgain = false
        def pPIN = false
        def dataSet = [:]
        if (debug) log.debug "Messaging Profile Data: (ptts) = '${ptts}', (pintentName) = '${pintentName}'"   
             
    if (ptts.contains("$name2")) {
    	ptts = ptts.replace("$name2", "$name1") }
    if (ptts.contains("$name4")) {
    	ptts = ptts.replace("$name4", "$name3") }
    if (ptts.contains("$name6")) {
    	ptts = ptts.replace("$name6", "$name5") }
        ptts = ptts.toLowerCase()
        log.debug "ptts == $ptts"


    // PARSING FOR MULTI ROOM COMMANDS 
	if (ptts.contains(" in the")) {
     	def newTts = ptts.split(" and").each { t -> 
            def ttsText = t.toLowerCase()
            log.warn "ttsText is: $ttsText"
        
	if (ttsText.contains(" in the")) { // FIND SECOND INTENTNAME
		def newIntent = ttsText.replaceAll("\\b in the .*\\b", "")
        newIntent = ttsText.replaceAll("\\b${newIntent}|bin the \\b", "")
	//	log.warn "newIntent is now: $newIntent"
			
            childApps.each {child ->
            	def childName = child.label.toString().toLowerCase() //.replaceAll("\\s","")  DO NOT REMOVE WHITE SPACE FROM SECOND INTENTNAME
                if ("${newIntent}".contains("${childName}")) {
                	log.warn "Found a second profile: $childName"
                        dataSet = [ptts:ttsText, pintentName:childName] 
					
                    if (ptts.startsWith("did") || ptts.contains("tell me about") || ptts.startsWith("get") || ptts.endsWith("tonight") || ptts.contains("weather") || ptts.contains("temperature") || ptts.contains("forecast") || ptts.contains("humidity") || ptts.contains("rain") || ptts.contains("wind") || ptts.startsWith("for") || ptts.startsWith("is") || ptts.startsWith("has") || ptts.startsWith("give") || ptts.startsWith("how") || ptts.startsWith("what") || ptts.startsWith("when") || ptts.startsWith("which") || ptts.startsWith("are") || ptts.startsWith("check") || ptts.startsWith("who")) {
                    	def pResponse = child.profileFeedbackEvaluate(dataSet)
                        outputTxt = pResponse.outputTxt
                    	pContCmds = pResponse.pContCmds
                    	pContCmdsR = pResponse.pContCmdsR
                    	pTryAgain = pResponse.pTryAgain
                    	} 
/*					if (ptts.startsWith("for") || ptts.startsWith("is") || ptts.startsWith("has") || ptts.startsWith("give") || ptts.startsWith("how") || ptts.startsWith("what") || ptts.startsWith("when") || ptts.startsWith("which") || ptts.startsWith("are") || ptts.startsWith("check") || ptts.startsWith("who")) {
						def pResponse = child.profileFeedbackEvaluate(dataSet)
                        outputTxt = pResponse.outputTxt
                    	pContCmds = pResponse.pContCmds
                    	pContCmdsR = pResponse.pContCmdsR
                    	pTryAgain = pResponse.pTryAgain
                    	}*/
                    else {  
                        def pResponse = child.profileEvaluate(dataSet)
                		outputTxt = pResponse.outputTxt + "  in the $pintentName"
                    	pContCmds = pResponse.pContCmds
                    	pContCmdsR = pResponse.pContCmdsR
                    	pTryAgain = pResponse.pTryAgain
                    	log.info "I have received this from the Lambda: ${outputTxt}"
                    	}
        		}
            }        
        }
    }
}

			childApps.each {child ->
    			def childName = child.label.toString().replaceAll("\\s","")  //removes white space from the room names to match incoming intent name
    		 	if ("${childName}" == pintentName) { 
                    if (debug) log.debug "Found a profile: '${pintentName}'"
                    pintentName = child.label
                    // recording last message
                    state.lastMessage = ptts
                    state.lastIntent = pintentName
                    state.lastTime = new Date(now()).format("h:mm aa", location.timeZone)
                    dataSet = [ptts:ptts, pintentName:pintentName] 
					def childRelease = child.checkRelease()
					log.warn "childRelease = $childRelease"

					if (ptts.startsWith("did") || ptts.startsWith("tell") || ptts.startsWith("get") || ptts.endsWith("tonight") || ptts.contains("weather") || ptts.startsWith("tell me about") || ptts.contains("temperature") || ptts.contains("forecast") || ptts.contains("humidity") || ptts.contains("rain") || ptts.contains("wind") || ptts.startsWith("for") || ptts.startsWith("is") || ptts.startsWith("has") || ptts.startsWith("give") || ptts.startsWith("how") || ptts.startsWith("what") || ptts.startsWith("when") || ptts.startsWith("which") || ptts.startsWith("are") || ptts.startsWith("check") || ptts.startsWith("who")) {
                    	def pResponse = child.profileFeedbackEvaluate(dataSet)
                        outputTxt = pResponse.outputTxt
                    	pContCmds = pResponse.pContCmds
                    	pContCmdsR = pResponse.pContCmdsR
                    	pTryAgain = pResponse.pTryAgain
                    	}
			/*		if (ptts.startsWith("for") || ptts.startsWith("is") || ptts.startsWith("has") || ptts.startsWith("give") || ptts.startsWith("how") || ptts.startsWith("what") || ptts.startsWith("when") || ptts.startsWith("which") || ptts.startsWith("are") || ptts.startsWith("check") || ptts.startsWith("who") ) {
                        def pResponse = child.profileFeedbackEvaluate(dataSet)
                        outputTxt = pResponse.outputTxt
                    	pContCmds = pResponse.pContCmds
                    	pContCmdsR = pResponse.pContCmdsR
                    	pTryAgain = pResponse.pTryAgain
                    	}*/
                    else {  
                        def pResponse = child.profileEvaluate(dataSet)
                		outputTxt = pResponse.outputTxt
                    	pContCmds = pResponse.pContCmds
                    	pContCmdsR = pResponse.pContCmdsR
                    	pTryAgain = pResponse.pTryAgain
                    	log.info "I have received this from the Lambda: ${outputTxt}"
                    	}
                	}
            	}
            
            
            if (outputTxt?.size()>0){
                return ["outputTxt":outputTxt, "pContCmds":pContCmds, "pShort":state.pShort, "pContCmdsR":pContCmdsR, "pTryAgain":pTryAgain, "pPIN":pPIN]
            }
            else {
                if (state.pShort != true){
                	outputTxt = "I'm sorry, but there seems to be an error, I am unable to $ptts, please try again"
                    }
                else {outputTxt = "I've heard " + pintentName + " , but I wasn't able to take any actions "} 
                pTryAgain = true
                return ["outputTxt":outputTxt, "pContCmds":pContCmds, "pShort":state.pShort, "pContCmdsR":pContCmdsR, "pTryAgain": pTryAgain, "pPIN":pPIN]
            }
        	
            def hText = "run a messaging and control profile"
			if (state.pShort != true){ 
				outputTxt = "Sorry, I heard that you were looking to " + hText + " but EchoSistant wasn't able to take any actions "
			}
			else {outputTxt = "I've heard " + pintentName + " , but I wasn't able to take any actions "}         
			pTryAgain = true
            pintentName = state.event
			return ["outputTxt":outputTxt, "pContCmds":pContCmds, "pShort":state.pShort, "pContCmdsR":pContCmdsR, "pTryAgain":pTryAgain, "pPIN":pPIN]              
    	}
    
/***********************************************************************************************************
		SMART HOME MONITOR STATUS AND KEYPAD HANDLER
***********************************************************************************************************/
// ALARM STATUS CHANGE FEEDBACK TO SPEAKERS
def alarmStatusHandler(evt) {
    if (fSecFeed) {
    //	def String = message
        def curEvtValue = evt.value
        log.info "Smart Home Monitor status changed to: ${curEvtValue}"
        if (shmSynthDevice || shmSonosDevice || shmSmc || shmEchoDevice) {
            if (evt.value == "away") {
                sendAwayCommand
                def message = "Attention, The alarm system is now set to armed away"
                if (shmEchoDevice) {
                    settings.shmEchoDevice.each { spk->
                        if(svr) {
                            int eVolume = eVolume as Integer
                            int volRestore = volRestore as Integer
                            spk.setVolumeSpeakAndRestore(eVolume, message, volRestore)
                        }
                        else{
                            spk.setVolumeAndSpeak(eVolume, message)
                        }
                    }
                }     
                if(shmSynthDevice) shmSynthDevice?.speak(message)
                if (shmSonosDevice) 
                shmSonosDevice?.playTextAndRestore(message)
                if (shmSmc) sendLocationEvent(name: "EchoSistantMsg", value: "ESv4.5 SHM Status Announcement", isStateChange: true, descriptionText: "${message}")
            }
            else if (evt.value == "stay") {
                def message = "Attention, The alarm system is now set to armed stay"
                if (shmEchoDevice) {
                    settings.shmEchoDevice.each { spk->
                        if(svr) {
                            int eVolume = eVolume as Integer
                            int volRestore = volRestore as Integer
                            spk.setVolumeSpeakAndRestore(eVolume, message, volRestore)
                        }
                        else{
                            spk.setVolumeAndSpeak(eVolume, message)
                        }
                    }
                }     
                if(shmSynthDevice) shmSynthDevice?.speak(message)
                if (shmSonosDevice) 
                shmSonosDevice?.playTextAndRestore(message)
                if (shmSmc) sendLocationEvent(name: "EchoSistantMsg", value: "ESv4.5 SHM Status Announcement", isStateChange: true, descriptionText: "${message}")
            }
            else if(evt.value == "off") {
                def message = "Attention, The alarm system has been disarmed"
                if (shmEchoDevice) {
                    settings.shmEchoDevice.each { spk->
                        if(svr) {
                            int eVolume = eVolume as Integer
                            int volRestore = volRestore as Integer
                            spk.setVolumeSpeakAndRestore(eVolume, message, volRestore)
                        }
                        else{
                            spk.setVolumeAndSpeak(eVolume, message)
                        }
                    }
                }     
                if(shmSynthDevice) shmSynthDevice?.speak(message)
                if (shmSonosDevice) 
                shmSonosDevice?.playTextAndRestore(message)
                if (shmSmc) sendLocationEvent(name: "EchoSistantMsg", value: "ESv4.5 SHM Status Announcement", isStateChange: true, descriptionText: "${message}")
            }
        }
    }
}


/*^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
X 																											X
X                       					UI FUNCTIONS													X
X                        																					X
/*^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
/************************************************************************************************************
   		UI - Version/Copyright/Information/Help
************************************************************************************************************/
private def textAppName() {
	def text = app.label // Parent Name
}
private def textLicense() {
	def text =
	"Licensed under the Apache License, Version 2.0 (the 'License'); "+
	"you may not use this file except in compliance with the License. "+
	"You may obtain a copy of the License at"+
	" \n"+
	" http://www.apache.org/licenses/LICENSE-2.0"+
	" \n"+
	"Unless required by applicable law or agreed to in writing, software "+
	"distributed under the License is distributed on an 'AS IS' BASIS, "+
	"WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. "+
	"See the License for the specific language governing permissions and "+
	"limitations under the License."
}

/************************************************************************************************************
   Page status and descriptions 
************************************************************************************************************/       
//	Naming Conventions: 
// 	description = pageName + D (E.G: description: mIntentD())
// 	state = pageName + S (E.G: state: mIntentS(),
/************************************************************************************************************/       

/** Configure Profiles Pages **/
def mRoomsS(){
    def result = ""
    if (childApps?.size()) {
    	result = "complete"	
    }
    result
}
def mRoomsD() {
    def text = "No Profiles have been configured. Tap here to begin"
    def ch = childApps?.size()     
    if (ch == 1) {
        text = "One profile has been configured. Tap here to view and change"
    }
    else {
    	if (ch > 1) {
        text = "${ch} Profiles have been configured. Tap here to view and change"
     	}
    }
    text
}
/** General Settings Page **/
def mSettingsS() {
    def result = ""
    if (ShowLicense || debug) {
    	result = "complete"	
    }
    result
}
def mSettingsD() {
    def text = "Tap here to Configure"
    if (ShowLicense || debug) { 
            text = "Configured"
    }
    text
}
/** Install and Support Page **/
def mSupportS() {
    def result = ""
    if (debug || trace) {
    	result = "complete"	
    }
    result
}
def mSupportD() {
    def text = "Tap here to View"
    if (debug || trace) { 
            text = "Configured"
    }
    text
}

def mSkillS(){
	def result = ""
    def IntentS = ""
    if (LARN) {
    	IntentS = "comp"
        result = "complete"
    }    	
    	result
}
def mSkillD() {
    def text = "Tap here to Configure"
	if (LARN) 
    {
        text = "Configured"
    }
    else text = "Tap here to Configure"
	    text
} 

def mIntentS(){
	def result = ""
    def IntentS = ""
    if (fSecFeed) {
    	IntentS = "comp"
        result = "complete"
    }    	
    	result
}
def mIntentD() {
    def text = "Tap here to Configure"
	def mIntentS = mIntentS()
    if (mIntentS) 
    {
        text = "Configured"
    }
    else text = "Tap here to Configure"
	    text
} 
def spellingsS() {def result = ""
    if (name1 || name3 || name5) {
    	result = "complete"}
   		result}
def spellingsD() {def text = "Tap here to configure" 
    if (name1 || name3 || name5) {
    	text = "Configured"}
    	else text = "Tap to Configure"
		text}

def mSecurityS() {def result = ""
    if (cMiscDev || cRoutines || uPIN_SHM || uPIN_Mode || fSecFeed || shmSynthDevice || shmSonosDevice || volume || resumePlaying) {
    	result = "complete"}
   		result}
def mSecurityD() {def text = "Tap here to configure settings" 
    if (cMiscDev || cRoutines || uPIN_SHM || uPIN_Mode || fSecFeed || shmSynthDevice || shmSonosDevice || volume || resumePlaying) {
    	text = "Configured"}
    	else text = "Tap to Configure"
		text}

def mDefaultsS() {def result = ""
    if (cLevel || cVolLevel || cTemperature || cHigh || cMedium || cLow || cFanLevel || cLowBattery || cInactiveDev || cFilterReplacement || cFilterSynthDevice || cFilterSonosDevice) {
    	result = "complete"}
   		result}
def mDefaultsD() {def text = "Tap here to configure settings" 
    if (cLevel || cVolLevel || cTemperature || cHigh || cMedium || cLow || cFanLevel || cLowBattery || cInactiveDev || cFilterReplacement || cFilterSynthDevice || cFilterSonosDevice) {
    	text = "Configured"}
    	else text = "Tap to Configure"
		text}         

def mDonationsS() {def result = ""
	if (LARN) {
    result = "complete"}
   		result}
def mDonationsD() {def text = "Your Acknowldegement is greatly Appriciated" 
	if (LARN) {
    text = "Your Acknowldegement is greatly Appriciated"}
    	else text = "Your Acknowldegement is greatly Appriciated"
		text}         

def mDeleteS() {def result = ""
	if (LARN) {
    result = "complete"}
   		result}
def mDeleteD() {def text = "You know you really do NOT want to do this" 
	if (LARN) {
    text = "You know you really do NOT want to do this"}
    	else text = "You know you really do NOT want to do this"
		text}         







/*********************************************************************************
**********************************************************************************
**********************************************************************************
**********************************************************************************
**********************************************************************************
**********************************************************************************
ALL CODE BELOW THIS POINT IS BASED DIRECTLY UPON THE WORK OF ANTHONY SANTILI AND 
MAY NOT BE USED IN ANY WAY, FASHION, OR FORM IN ANY SOFTWARE NOT SPECIFIED BY
WRITTEN PERMISSION FROM THE ORIGINAL AUTHOR. 
**********************************************************************************
**********************************************************************************
**********************************************************************************
**********************************************************************************
**********************************************************************************
**********************************************************************************

/*********************************************************************************
                    ALEXA SKILL MANAGEMENT FUNCTIONS - START
**********************************************************************************/
def mobileCltTypeSect() {
    section("Mobile Client") {
        paragraph title: "Why do we need this?", "This allows us to provide you with an experience optimized for your SmartThings Mobile App"
        input(name: "mobileClientType", title:"Primary Mobile Device?", type: "enum", required: true, submitOnChange: true, metadata: [values:["android":"Android", "ios":"Apple iOS"]],
                image: getAppImg("${(settings?.mobileClientType) ? "${settings?.mobileClientType}" : "mobile_device"}.png"))
    }
}

def getAlexaAppSkillUrl(id) { return settings?.mobileClientType == "android" ? "https://alexa.amazon.com/?fragment=skills/beta/${id}" : "alexa://alexa?fragment=skills/beta/${id}"}

def getProfileList() {
	return getProfileApps()
  	}

def processActionsPage(params){
    def sData = params?.sData
	if(params?.sData) { atomicState.actionMaintPageParams = params }
    else { sData = atomicState?.actionMaintPageParams?.sData }
    dynamicPage(name: "processActionsPage", uninstall: false, install: false, refreshInterval: 8) {
        def actType = sData?.actType
        def actTypeCap = sData?.actType?.toString().capitalize()
        def locale = sData?.locale ?: null
        def itemsToCrt = actType == "profile" ? [] : [:]; List itemsToRem = []; List itemsToUpd = [];
        if(atomicState?.actionsProcDone == null) { atomicState?.actionsProcDone = false }
        try {
            def actRes = atomicState?.actionMaintResults
            if(atomicState?.actionMaintInProg == true) {
                section("${actTypeCap} Maintenance Status") {
                    paragraph title: "${actTypeCap} Maintenance in Progress", "Page will refresh and results will be listed below.\nPlease wait till you see Completed Message before leaving", state: "complete", image: getAppImg("info.png")
                }
                if(actRes?.crtDone?.size()>0) {
                    section("Creation Results") {
                        actRes?.crtDone?.sort()?.unique()?.each { crt-> paragraph title: "${actTypeCap}: (${crt})", "Created Successfully...", state: "complete", image: getAppImg("active.png") }
                    }
                }
                if(actRes?.updDone?.size()>0) {
                    section("Update Results") {
                        actRes?.updDone?.sort()?.unique()?.each { upd-> paragraph title: "${actTypeCap}: (${upd})", "Updated Successfully..." }
                    }
                }
                if(actRes?.remDone?.size()>0) {
                    section("Removal Results") {
                        actRes?.remDone?.sort()?.unique()?.each { rem-> paragraph title: "${actTypeCap}: (${rem})", "Removed Successfully...", state: "complete", image: getAppImg("active.png") }
                    }
                }
            } else if(atomicState?.actionsProcDone == true) {
                section ("") { 
                    paragraph title: "${actTypeCap} Maintenance is Complete...", ""
                    if(!actRes?.remDone?.size() && !actRes?.crtDone?.size() && !actRes?.updDone?.size()) { paragraph title: "Everything is Good.  There was Nothing to do.", "", state: "complete", image: getAppImg("ok_circle.png") }
                    if(actRes?.remDone?.size()) { paragraph title: "Removed (${actRes?.remDone?.unique()?.size()}) ${actTypeCap}s", "", state: "complete", image: getAppImg("ok_circle.png") }
                    if(actRes?.crtDone?.size()) { paragraph title: "Created (${actRes?.crtDone?.unique()?.size()}) ${actTypeCap}s", "", state: "complete", image: getAppImg("ok_circle.png") }
                    if(actRes?.updDone?.size()) { paragraph title: "Updated (${actRes?.updDone?.unique()?.size()}) ${actTypeCap}s", "", state: "complete", image: getAppImg("ok_circle.png") }
                    paragraph "Press Done/Save to go back...", state: "complete"
                }
            } else {
                List skpd = []; List uptd = []; List crtd = []; List rmvd = [];
                if(actType == "skill") {
                    def skillData = atomicState?.skillVendorData ?: [:]
                    skillData?.each { sd->
                        def sName = sd?.nameByLocale[locale] as String
                        if(getSelectedSkills(true, true)?.find { sName == it } == null) {
                            rmvd?.push(sName)
                            itemsToRem?.push(sd?.skillId)
                            // log.warn "Un-Selected Skill Marked for Removal: (${sName})"
                            skillData -= sd
                        }
                    }
                    getSelectedSkills(false, true)?.each { selSkill ->
                        def skName = "EchoSistant - ${selSkill}"
                        def skCnt = 1
                        def existingSkillName = skillData?.findAll { it?.nameByLocale[locale]?.toString() == skName }
                        if(existingSkillName?.size()>0) {
                            existingSkillName?.each { prof ->
                                if(skCnt>1) {
                                    itemsToRem?.push(prof?.skillId)
                                    if(skCnt > 1) {
                                        // log.warn "Duplicate Skill Marked for Removal: ${prof?.skillId} - #${skCnt}"
                                        rmvd.push("Duplicate ${prof?.nameByLocale[locale]} - #${skCnt}")
                                    }
                                } else {
                                    //itemsToUpd?.push("${selSkill}:${prof?.skillId}")
                                    //uptd?.push(skName)
                                }
                                skCnt = skCnt+1
                            }
                        } else {
                            itemsToCrt << ["$selSkill":[lambUrn: sData?.lambUrn, vendId: sData?.vendId]]
                            crtd?.push(skName)
                        }
                    }
                }
                else if (actType == "profile") {
                    def sApp = getStorageApp()
                    def rmData = sApp?.getStateVal("stRoomMap") ?: []
                    def pApps = getProfileApps()
                    def selctdRms = settings?.roomsSelForProfCreate.collect { it }
                    selctdRms?.each { selRm ->
                        def roomData = rmData.find { selRm == it?.id }
                        if(roomData) {
                            def rmId = roomData?.id as String
                            def rmName = roomData?.name as String
                            def roomCnt = 1
                            def rmProfs = pApps?.findAll { it?.getRoomId() == rmId }
                            if(rmProfs?.size()>0) {
                                rmProfs?.each { prof ->
                                    def profRmId = prof?.getRoomId() as String
                                    if(roomCnt>1) {
                                        itemsToRem?.push(prof?.id)
                                        if(roomCnt > 1) {
                                            // log.warn "Duplicate Profile Marked for Removal: ${prof?.id} - #${roomCnt}"
                                            rmvd.push("Duplicate ${rmName} - #${roomCnt}")
                                        }
                                    } else {
                                        if(settings?.profileRoomSyncWithST) {
                                            itemsToUpd?.push(prof?.id)
                                            uptd?.push(rmName)
                                        } else { skpd.push(rmName) }
                                    }
                                    roomCnt = roomCnt+1
                                }
                            } else {
                                itemsToCrt << [roomData:roomData]
                                crtd?.push(rmName)
                            }
                        }
                    }
                    def remove = pApps?.findAll { !(it?.getRoomId() in selctdRms) }
                    remove?.each { rm ->
                        itemsToRem?.push(rm?.id)
                        rmvd.push(rm?.getRoomName())
                        // log.warn "Unselected Profile ${rm?.label} Marked for Removal"
                    }
                }
                section(""){
                    def additDesc = actType == "skill" ? "This process will take about 10 sec. per skill" : "This process will take about 20-60 Seconds..."
                    paragraph title: "NOTICE!!!\nPlease remain on this page until this changes to say it's completed.", "The changes listed below have not happened yet.\n${additDesc}", required: true, state: null
                }
                if(rmvd?.size()>0) { section("Removing ${actTypeCap}s:") { paragraph title: "(${rmvd?.size()}) ${actTypeCap}s Scheduled for Removal", "", state: "complete" } }
                if(crtd?.size()>0) { section("Creating ${actTypeCap}s:") { paragraph title: "(${crtd?.size()}) ${actTypeCap}s Scheduled for Creation", "", state: "complete" } }
                if(uptd?.size()>0) { section("Updating ${actTypeCap}s:") { paragraph title: "(${uptd?.size()}) ${actTypeCap}s Scheduled for Update", "", state: "complete" } }
                if(skpd?.size()>0) { section("Skipped ${actTypeCap}s:") { paragraph title: "Skipping (${skpd?.size()}) ${actTypeCap}s", "", state: "complete" } }

                atomicState?.actionsProcDone = true
                if(actType == "skill") { atomicState?.applySkillChgsUpdDt = getDtNow() }
                if(actType == "profile") { atomicState?.applyProfChgsUpdDt = getDtNow() }
                //This will determine which tasks need to be performed on the action type (profile/skill)
                atomicState?.actionMaintResults = [:]
                def am = atomicState?.actionMaintItems ?: [:]
                if(itemsToCrt?.size()) { am["crt"] = itemsToCrt }
                if(itemsToRem?.size()) { am["rem"] = itemsToRem?.unique() }
                if(itemsToUpd?.size()) { am["upd"] = itemsToUpd }
                atomicState?.actionMaintItems = am
                runIn(4, "actionMaintCheck", [overwrite: true, data:["addPass":false, "actType":actType]])
            }
        } catch (ex) {
            log.error "processActionsPage error: ${ex.message}"
        }
    }
}

def awsSkillConfigPage(){
	log.warn "Larn is: $LARN"
    atomicState?.actionsProcDone = false
    dynamicPage(name: "awsSkillConfigPage", uninstall: false, install: false) {
        def locale = getSkillLocale()
        awsLocaleSection()
        if(!locale) { 
            awsLocaleSection() 
        } else {
            if(atomicState?.skillAuthData == null) {
                section("Get Skill Management Token") {
                    href url: awsSkillAuthUrl(), title: "Get Code Used to Generate Tokens", description: "On the next page enter your amazon credentials and when the code is returned copy/paste into the input below."
                    input "skillTokenCode", "text", title: "Enter the Code Received", required: false, submitOnChange: true
                    href "awsSkillAuthGenPage", title: "Convert Code to Auth Token", hideWhenEmpty: !settings?.skillTokenCode, required: false, description: "This will generate the Auth Token to manage skills"
                }
            } else {
                def token = getSkillToken()
                if(token) {
                    def tokenData = getSkillTokenData()
                    def str = ""
                    str += "Language: (${getSkillLocale()})"
                    str += "\nStatus: (${tokenData?.exp ? "Valid" : "Invalid"})"
                    str += " | Expires: (${tokenData?.exp} sec)"
                    section ("") { paragraph title: "Skill Security Token", str }
                    if(!settings?.mobileClientType) { 
                        mobileCltTypeSect()
                    } 
                    else { 
                        def vendors = getSkillVendors()
                        // log.debug "vendors: $vendors"
                        if(vendors?.size()) {
                            def vendId = vendors?.vendors?.find { it?.roles?.contains("ROLE_ADMINISTRATOR") }?.id ?: null
                            if(vendId) {
                                atomicState?.skillVendorId = vendId
                                def skillVendorData = getSkillVendorById(vendId)?.skills?.findAll { it?.nameByLocale?."${locale}"?.startsWith("EchoSistant - ") }
                                atomicState?.skillVendorData = skillVendorData
							section ("Lambda ARN") {
                            	def LARN = getLarn()
                        		if (!LARN) {
                                input "LARN", "text", title: "Input your ARN Exactly as shown on the Lambda Page", required: false, submitOnChange: true
                            		}
                                }
                                if(skillVendorData?.size()) {    
                                    section("Skills Configured") {
                                        paragraph title: "NOTICE", "Skills Are NOT Enabled by default\nPlease click on a Skill below to Open under the Alexa Mobile App where you can enable it.", required: true, state: null
                                        skillVendorData?.each { sk-> 
                                            def sDesc = ""
                                            sDesc += "Invocation: ${getSkillInvoc(sk?.nameByLocale[locale])}"
                                    //        sDesc += "\n\nLast Modified:\n${prettyDt(sk?.lastUpdated, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")}"
                                            sDesc += "\n\nTap to Open Skill in Alexa App"
                                            href url: getAlexaAppSkillUrl(sk?.skillId), style:"external", title: "${sk?.nameByLocale[locale]}", description: sDesc
                                        }
                                    }
                                }
                                section("Custom Skills") {
                                    input "skillProfilesSelected", "enum", title: "Create Skills for these Profiles (Optional)", multiple: true, required: false, submitOnChange: true, options: getProfileApps().sort() //getAllProfileNames()//, image: getAppImg("check_list.png")
                                }
                                section("Apply Changes") {
                                    def lrfshdt = atomicState?.applySkillChgsUpdDt
                                    def rDes = lrfshdt ? "Last Updated:\n(${prettyDt(lrfshdt)})\n\nTap here to Proceed..." : "Tap here to Proceed..."
                                    paragraph title: "What does this do?", "This does the following:\n • Creates Manditory Skills\n • Adds/Removes Custom Skills You Selected"
                                    href "processActionsPage", title: "Apply/Process Skill Changes", required: false, description: rDes, state: (lrfshdt ? "complete": null), image: getAppImg("finish.png"),
                                            params: [sData:[lambUrn:atomicState?.lambdaData?.ARN, vendId:vendId, locale:locale, actType:"skill"]]                                    
                                }
                                 
                            } else { section("") { paragraph title: "Skill Data Issue", "Unable to find a Valid VendorID", required: true, state: null } }
                        }
                    }
                } else { section ("") { paragraph  title: "Skill Token Issue", "Token Missing/Invalid", required: true, state: null } }
            }
            section("Alpha Tools:") {
                input "clearActionMaint", "bool", title: "Clear Skill Maintenance Tasks", required: false, defaultValue: false, submitOnChange: true
                if(settings?.clearActionMaint == true) { clearActionMaint() }
                input "clearSkillAuth", "bool", title: "Clear Skill Token Data", required: false, defaultValue: false, submitOnChange: true
                if(settings?.clearSkillAuth == true) { clearSkillAuth() }
                input "clearAllSkills", "bool", title: "Remove All Skills", required: false, defaultValue: false, submitOnChange: true
                if(settings?.clearAllSkills == true) { clearAllSkills() }
            }
        }
    }
}

def clearSkillAuth() {
    settingRemove("clearSkillAuth")
    atomicState?.skillAuthData = null
    atomicState?.skillVendorData = null
    atomicState?.skillVendorId = null
}

def clearAllSkills() {
    settingRemove("clearAllSkills")
    def sData = atomicState?.skillVendorData
    def sm = [:]
    List itemsToRem = []
    if(sData?.size()>0) {
        sData?.each { sk -> itemsToRem?.push(sk?.skillId) }
        sm["rem"] = itemsToRem
    }
    atomicState?.actionMaintItems = sm
    atomicState?.skillRemovalInProg = true
    runIn(2, "actionMaintCheck", [overwrite: true, data:[addPass:false, actType:"skill", clearSkills: true]])
}

def getAllProfileNames(cln=true) {
    def items = atomicState?."${cln ? "profClnRoomNames" : "profRoomNames"}" ?: []
    if(!atomicState?."${cln ? "profClnRoomNames" : "profRoomNames"}" || !items?.size()) {
        items = getProfileApps()
        atomicState?."${cln ? "profClnRoomNames" : "profRoomNames"}" = items
    }
    return items?.sort()
}

def awsSkillAuthGenPage() {
    def result = true
    if(!atomicState?.skillAuthData) { result = getTokenFromCode(settings?.skillTokenCode) }
    dynamicPage(name: "awsSkillAuthGenPage", title: "", refreshInterval: (!atomicState?.skillAuthData ? null : null), uninstall: false, install: false){
        section ("Auth Process") {
            if(atomicState?.skillAuthData) {
                paragraph "Token Aquired Successfully...", state: "complete"
            } else {
                paragraph "There was an issue getting the Auth Data", required: true, state: null
            }
        }
    }
}

def getTokenFromCode(code, refresh=false) {
    log.trace "getTokenFromCode(code: $code, refresh: $refresh)"
    if(refresh) { log.debug "Current Skill Token Expired... Attempting to Refresh it..." }
    def bodyItems = [
        grant_type: "authorization_code",
        client_id: "amzn1.application-oa2-client.aad322b5faab44b980c8f87f94fbac56",
        client_secret: "1642d8869b829dda3311d6c6539f3ead55192e3fc767b9071c888e60ef151cf9",
        scope: "alexa::ask:skills:readwrite alexa::ask:models:readwrite alexa::ask:skills:test",
        code: "${code}",
        redirect_uri: "https://s3.amazonaws.com/ask-cli/response_parser.html",
        state: "Ask-SkillModel-ReadWrite"
    ]
    if(refresh && atomicState?.skillAuthData?.refresh_token) {
        bodyItems["grant_type"] = "refresh_token"
        bodyItems["refresh_token"] = atomicState?.skillAuthData?.refresh_token
    }
    def reqParams = [
        uri: "https://api.amazon.com/auth/O2/token",
        contentType: "application/x-www-form-urlencoded",
        autherization: "Basic YW16bjEuYXBwbGljYXRpb24tb2EyLWNsaWVudC5hYWQzMjJiNWZhYWI0NGI5ODBjOGY4N2Y5NGZiYWM1NjoxNjQyZDg4NjliODI5ZGRhMzMxMWQ2YzY1MzlmM2VhZDU1MTkyZTNmYzc2N2I5MDcxYzg4OGU2MGVmMTUxY2Y5",
        accept: "application/json",
        userAgent:"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36",
        body: toQueryString(bodyItems, false)
    ]
    def respData = makeSkillRequests(reqParams, "httpPost", "getTokenFromCode", false)
    if(respData) {
        def authData = [:]
        respData?.each { item -> authData = parseJson(item?.toString()) }
        if(authData && authData != [:]) {
            authData["token_modified_dt"] = getDtNow()
            atomicState?.skillAuthData = authData
            settingRemove("skillTokenCode")
            return true
        }
    }
    return false
}

def getSkillToken() {
    if(atomicState?.skillAuthData?.access_token && atomicState?.skillAuthData?.refresh_token) {
        def tokenData = getSkillTokenData()
        Integer expSec = tokenData?.exp ?: 3601
        if(expSec >= 3600) { getTokenFromCode(settings?.skillTokenCode, true) }
        return atomicState?.skillAuthData?.access_token
    } 
    log.warn "Skill Auth Data Missing..."
    return null
}

def getSkillTokenData() {
    def params = [ uri: "https://api.amazon.com/auth/O2/tokeninfo", query: [ access_token: atomicState?.skillAuthData?.access_token ] ]
    return makeSkillRequests(params, "httpGet", "getSkillTokenData", false)
}

def getSkillVendors() {
    def params = [ uri: "https://api.amazonalexa.com/v0/vendors", headers: [authorization: atomicState?.skillAuthData?.access_token ] ]
    return makeSkillRequests(params, "httpGet", "getSkillVendors", false)
}

def getSkillVendorById(id) {
    def params = [ uri: "https://api.amazonalexa.com/v0/skills?vendorId=${id}&maxResults=50", headers: [authorization: atomicState?.skillAuthData?.access_token ], contentType: "application/json" ]
    return id ? makeSkillRequests(params, "httpGet", "getSkillVendorById", false) : null
}

def createSkill(skillName, urn, vendId) {
    def params = [ uri: "https://api.amazonalexa.com/v0/skills", headers: [authorization: atomicState?.skillAuthData?.access_token ], contentType: "application/json", accept: "application/json", body: generateSkillManifest(skillName, vendId, urn) ]
    return makeSkillRequests(params, "httpPostJson", "createSkill", true)
}

def removeSkill(skillId) {
    def params = [ uri: "https://api.amazonalexa.com/v0/skills/${skillId}", headers: [authorization: atomicState?.skillAuthData?.access_token ], contentType: "application/json", accept: "application/json" ]
    def resp = makeSkillRequests(params, "httpDelete", "removeSkill", true)
    // log.debug "message: ${resp?.message}"
    // log.debug "violations: ${resp?.violations}"
    // log.debug "resp: $resp | ${((!resp?.violations && resp == null) || resp == "" || (resp?.message?.equals("Resource not found.")))}"
    if((!resp?.violations && resp == null) || resp == "" || (resp?.message?.equals("Resource not found."))) { return true }
    return false
}

def updateSkillModel(skillName, skillId) {
    def params = [
        uri: "https://api.amazonalexa.com/v0/skills/${skillId}/interactionModel/locales/${getSkillLocale()}", headers: [authorization: atomicState?.skillAuthData?.access_token ], contentType: "application/json", accept: "application/json",
        body: generateSkillModelJson(skillName)
    ]
    def resp = makeSkillRequests(params, "httpPostJson", "updateSkillModel", true)
    if( (!resp?.violations && resp == null) || resp == [:] || (resp?.violations && resp?.violations[0] && resp?.violations[0]?.message.toString().contains("OngoingBuild"))) { return true }
    else if (status == 400) {
    log.warn "While building skill: $skillName there was a status violation. Please correct the issue and try again"
    return false
    }
}

def getSkillNameFromDataById(id) {
    def item = atomicState?.skillVendorData?.find { it?.skillId == id } 
    return item ? item?.nameByLocale[getSkillLocale()] : null
}

def getSkillExistsByName(name) {
    return getSkillVendorById(atomicState?.vendorId)?.skills?.find { it?.nameByLocale[locale] == name }
}

def makeSkillRequests(params, reqType, type, logOutput=false) {
    def response = null
    def status = null
    def okStatusRange = 200..204
    try {    
        if(params && type) {
            "${reqType}"(params) { resp ->
                response = resp?.data
                status = resp?.status
            }
            if(logOutput) { log.trace "$type | status: (${status}) | reqType: ($reqType) | resp: ${response}" }
            if(status in okStatusRange && response) { return response }
        }
    } catch (ex) {
        if(ex instanceof groovyx.net.http.HttpResponseException) {
            status = ex?.getStatusCode()
            response = ex?.getResponse()?.data
            if(response?.message?.equals("Token is invalid/expired")) { getTokenFromCode(settings?.skillTokenCode, true) }
            log.error "makeSkillRequests($type) | reqType: $reqType | Status: (${ex?.getStatusCode()}) | ErrorResponse: ${response}"
        } else { log.error "makeSkillRequests($type) | reqType: $reqType | Exception: $ex" }
        return response
    }
}

def generateSkillManifest(skillName, vendorId, lambArn, retJson=true) {
    lambArn = getLarn()
    log.debug "generateSkillManifest | skillName: $skillName | vendId: $vendorId | lambArn: $lambArn | region: ${getSkillLocale()}"
    def exampItems = []
    if(skillName == settings?.defaultInvocation) { 
        exampItems = ["tell the ${skillName} to turn off the lights in the living room", "tell the ${skillName} lock the front door in 5 minutes", "tell the ${skillName} good night"]
    } else {
        exampItems = ["turn the ${skillName} lights off ", "turn the lights off in the ${skillName}", "tell the ${skillName} good night"]
    }
    def region = "NA"
    if (getSkillLocale()?.toString() == "en-GB") {
    	region = "EU"
    }
    def manifest = [
        "vendorId": vendorId,
        "skillManifest":[
            "publishingInformation": [
                "locales": [ 
                    "${getSkillLocale()?.toString()}": [ 
                        "summary": "EchoSistant", 
                        "examplePhrases": exampItems, 
                        "keywords": [ "EchoSistant" ], 
                        "name": "EchoSistant - ${skillName?.toString().capitalize()}",
                        "smallIconUri": "", //https://echosistant.com/es5_content/images/echosistant_v5_108px.png", 
                        "largeIconUri": "", //https://echosistant.com/es5_content/images/echosistant_v5_512px.png",
                        "description": "EchoSistant"
                    ]
                ],
                "isAvailableWorldwide": true, 
                "testingInstructions": "One App to rule them all", 
                "category": "SMART_HOME", 
                "distributionCountries": ["US", "GB"]
            ],
            "apis": [ "custom": [ "endpoint": [ "uri": lambArn ], "interfaces": [ ["type": "RENDER_TEMPLATE"] ] ] ], 
            "manifestVersion": "1.0",
            "permissions": [ ["name": "alexa::devices:all:address:full:read"], ["name": "alexa::household:lists:read"], ["name": "alexa::household:lists:write"] ],
            "privacyAndCompliance": [ 
                "allowsPurchases": false, 
                "locales": [ 
                    "${getSkillLocale()?.toString()}": [ "privacyPolicyUrl": "http://www.echosistant.com" ]
                ], 
                "isExportCompliant": true, 
                "containsAds": false, 
                "isChildDirected": false, 
                "usesPersonalInfo": true 
            ],
            "events": [
                "endpoint": [ "uri": lambArn ],
                "subscriptions": [
                    ["eventName": "SKILL_ENABLED"],
                    ["eventName": "SKILL_DISABLED"],
                    ["eventName": "SKILL_PERMISSION_ACCEPTED"],
                    ["eventName": "SKILL_PERMISSION_CHANGED"],
                    ["eventName": "SKILL_ACCOUNT_LINKED"]
                ],
                "regions": [
                    "${region}": [
                        "endpoint": ["uri": lambArn]
                    ]
                ]
            ]
        ]
    ]
    // log.debug "manifest: ${manifest?.skillManifest?.publishingInformation?.locales}"
    def json = new JsonOutput().toJson(manifest)
    def res = new JsonOutput().prettyPrint(json)
    return retJson ? res : manifest
}

def generateSkillModelJson(skillName="here", retJson=true) {  //skillName?.toString().capitalize()
    log.debug "generateSkillModelJson skillName: $skillName"
    def appStatus = [ [ "name": "AppStatus", "samples":[ "version info", "app status", "app details", "instance status", "app info" ] ] ]
    def updSettings = [ [ "name": "UpdateSettings", "samples":[ "update settings", "update configuration" ] ] ]
    def intentName = "${skillName}"?.toString().capitalize().replaceAll("\\s","")
    log.warn "The intentName is now: $intentName"
    def intentMap = [
        "interactionModel": [
            "languageModel": [
                "invocationName": "${skillName?.toLowerCase()}",
                "intents":[
                    [ "name": "AMAZON.HelpIntent", "samples": [ "what can i do", "i need help", "i need ideas", "what can i say", "what is this", "give me an idea", "i'm lost" ] ],
                    [ "name": "AMAZON.MoreIntent", "samples": [] ], [ "name": "AMAZON.NavigateHomeIntent", "samples": [] ], [ "name": "AMAZON.NavigateSettingsIntent", "samples": [] ], [ "name": "AMAZON.NextIntent","samples": [] ],
                    [ "name": "AMAZON.NoIntent", "samples": [] ], [ "name": "AMAZON.PageDownIntent", "samples": [] ], [ "name": "AMAZON.PageUpIntent", "samples": [] ], [ "name": "AMAZON.PreviousIntent", "samples": [] ], 
                    [ "name": "AMAZON.ScrollDownIntent", "samples": [] ], [ "name": "AMAZON.ScrollLeftIntent", "samples": [] ], [ "name": "AMAZON.ScrollRightIntent", "samples": [] ], [ "name": "AMAZON.ScrollUpIntent", "samples": [] ],
                    [ "name": "AMAZON.CancelIntent", "samples": [] ], [ "name": "AMAZON.StopIntent", "samples": [] ], [ "name": "AMAZON.YesIntent", "samples": [] ],
                    [ "name": "${intentName}", "slots": [ [ "name": "ttstext", "type": "CATCH_ALL" ] ], "samples": [ "{ttstext}" ] ]
                ],
                "types":[ [ 
                    "values": [
                        [ "name":[ "value": "turn", "synonyms": [] ] ], [ "name":[ "value": "put to", "synonyms": [] ] ], [ "name":[ "value": "enter are void", "synonyms": [] ] ], [ "name":[ "value": "over around and under", "synonyms": [] ] ],
                        [ "name":[ "value": "light switch fan outlet relay", "synonyms": [] ] ], [ "name":[ "value": "water speaker list media set above", "synonyms": [] ] ], [ "name":[ "value": "on start enable engage open begin unlock unlocked", "synonyms": [] ] ],
                        [ "name":[ "value": "delay wait until after around within in about for", "synonyms": [] ] ], [ "name":[ "value": "darker too bright dim dimmer decrease lower low softer less", "synonyms": [] ] ],
                        [ "name":[ "value": "give is tell what how is when which are how many check who status", "synonyms": [] ] ], [ "name":[ "value": "increase more too dark not bright enough brighten brighter turn up", "synonyms": [] ] ],
                        [ "name":[ "value": "off stop cancel disable disengage kill close silence lock locked quit end", "synonyms": [] ] ], [ "name":[ "value": "door garage window shade curtain blind thermostat indoor outdoor vent valve", "synonyms": [] ] ]
                    ], "name": "CATCH_ALL" ] 
                ]
            ]
        ]
    ]
    if(skillName in ["here", "Here"]) { 
        intentMap?.interactionModel?.languageModel?.intents = intentMap?.interactionModel?.languageModel?.intents + updSettings 
    } else { intentMap?.interactionModel?.languageModel?.intents = intentMap?.interactionModel?.languageModel?.intents + updSettings + appStatus }
    def json = new JsonOutput().toJson(intentMap)
    def res = new JsonOutput().prettyPrint(json)
    // log.debug "intentMap: ${retJson ? res : intentMap}"
    return retJson ? res : intentMap
}

def getTokenExpireDtSec() { return !atomicState?.skillAuthData?.token_modified_dt ? 7200 : GetTimeDiffSeconds(atomicState?.skillAuthData?.token_modified_dt, null, "getTokenExpireDtSec").toInteger() }

def toQueryString(Map m, encode=true) {
	return m.collect { k, v -> "${k}=${encode ? URLEncoder.encode(v.toString()) : v?.toString()}" }.sort().join("&")
}

def convSkillName(name) {
    return "EchoSistant - $name"
}

def getSelectedSkills(sendFullName, manditory=true) {
    def sel = []
    sel = sel + (settings?.skillProfilesSelected ? settings?.skillProfilesSelected?.collect { sendFullName ? convSkillName(it) : it } : [])
    return sel
}

void procSkillCreate(data) {
    def curItem = null
    def items = atomicState?.actionMaintItems
    def maintRes = atomicState?.actionMaintResults ?: [:]
    // log.debug "procSkillCreate | items: $items"
    Map crtRem = [:]
    try {
        if(!items?.crt?.size()) {
            runIn(2, "actionMaintCheck", [overwrite: true, data:[addPass:false, actType:data?.actType]])
            return
        }
        def cnt = 1
        if(items?.crt?.size()) {
            items?.crt?.each { crtItem ->
                log.debug "crtItem: $crtItem"
                if(cnt<=5) {
                    curItem = crtItem
                    def res = createSkill(crtItem?.key, crtItem?.value?.lambUrn, crtItem?.value?.vendId)
                    if(res?.skillId) { 
                        if(updateSkillModel(crtItem?.key, res?.skillId)) {
                            // LogAction("Skill (${crtItem?.key})", "trace", true)
                            crtRem << crtItem
                            if(!maintRes?.crtDone) { maintRes["crtDone"] = [] }
                            maintRes?.crtDone.push("EchoSistant - ${crtItem?.key}")
                            atomicState?.actionMaintResults = maintRes
                        }
                    } else { LogAction("procSkillCreate issue, Missing skillData: ${crtItem}","error",true) }
                    cnt = cnt+1
                }
            }
        }
    } catch (ex) { 
        if(ex instanceof java.util.ConcurrentModificationException) {
            // log.debug "Skill is Currently being Created"
            //if(curItem) { items?.upd.remove(curItem) }
        } else { log.error "procSkillCreate Exception:", ex }
    }
    crtRem?.each { c-> items?.crt?.remove(c?.key) }
    atomicState?.actionMaintItems = items
    atomicState?.actionMaintResults = maintRes
    runIn(2, "actionMaintCheck", [overwrite: true, data:[addPass:true, actType:data?.actType]])
}

void procSkillUpdate(data) {
    def curItem = null
    def items = atomicState?.actionMaintItems
    def maintRes = atomicState?.actionMaintResults ?: [:]
    List updRem = []
    try {
        if(!items?.upd?.size()) {
            runIn(2, "actionMaintCheck", [overwrite: true, data:[addPass:false, actType:data?.actType]])
            return
        }
        def cnt = 1
        if(items?.upd?.size()) {
            items?.upd?.each { updItem->
                if(cnt<=5) {
                    curItem = updItem
                    def spl = updItem?.split(":")
                    if(spl[0] && spl[1]) {
                        if(updateSkillModel(spl[0], spl[1])) {
                            // LogAction("Updated Skill: (${spl[0]})", "trace", true) 
                            updRem?.push(updItem)
                            if(!maintRes?.updDone) { maintRes["updDone"] = [] }
                            maintRes?.updDone.push("EchoSistant - ${spl[0]}")
                            atomicState?.actionMaintResults = maintRes
                            cnt = cnt+1
                        }
                    }
                }
            }
        }
    } catch (ex) {
        if(ex instanceof java.util.ConcurrentModificationException) {
            // log.debug "Skill is Already being built"
            if(curItem) { items?.upd.remove(curItem) }
        } else { log.error "There was an error updating skill:", ex }
    }
    updRem?.each { u-> items?.upd?.remove(u) }
    atomicState?.actionMaintItems = items
    atomicState?.actionMaintResults = maintRes
    runIn(2, "actionMaintCheck", [overwrite: true, data:[addPass:true, actType:data?.actType]])
}

void procSkillRemoval(data) {
    def curItem = null
    def items = atomicState?.actionMaintItems
    def maintRes = atomicState?.actionMaintResults ?: [:]
    List remRem = []
    try {
        if(!items?.rem?.size()) {
            runIn(2, "actionMaintCheck", [overwrite: true, data:[addPass:false, actType:data?.actType]])
            return
        }
        def cnt = 1
        if(items?.rem?.size()) {
            items?.rem?.each { remItem->
                if(cnt<=5) {
                    curItem = remItem
                    def name = getSkillNameFromDataById(remItem)
                    if(removeSkill(remItem)) {
                        // LogAction("Removed Skill: (${name})", "warn", true)
                        remRem?.push(remItem)
                        if(!maintRes?.remDone) { maintRes["remDone"] = [] }
                        maintRes?.remDone.push("EchoSistant - ${name}")
                        atomicState?.actionMaintResults = maintRes
                        cnt = cnt+1
                    }
                }
            }
        }
    } catch (ex) {
        if(ex instanceof java.util.ConcurrentModificationException) {
            // log.debug "Skill is Already being removed"
            if(curItem) { items?.rem.remove(curItem) }
        } else {
            log.error "There was an error processing skill removal:", ex
        }
    }
    remRem?.each { r-> items?.rem?.remove(r) }
    atomicState?.actionMaintItems = items
    atomicState?.actionMaintResults = maintRes
    runIn(2, "actionMaintCheck", [overwrite: true, data:[addPass:true, actType:data?.actType]])
}

def awsLocaleSection() {
    section("Alexa Skills Region") {
        paragraph title: "Why do we need this?", "This allows us to target the appropriate server for your region"
        input(name: "awsLocale", title:"Please Select your Region", type: "enum", required: true, submitOnChange: true, defaultValue: null, metadata: [values:["US":"US", "UK":"UK"]], image: getAppImg("web.png"))
    	if (awsLocale == "US") {
        	input(name: "awsRegion", title:"Please Select your AWS Lambda Region", type: "enum", required: true, submitOnChange: true, defaultValue: "us-east1", metadata: [values:["US East":"us-east-1","US West":"us-west-2"]])
    	}
    }
}

def getAwsRegion() {
    settings?.awsLocale == "UK" ? "eu-west-1" : "US" ? "${awsRegion}" : null //"us-east-1" //
    log.warn "awsLocale is: $settings.awsLocale"
	return
}
/*********************************************************************************
                    ALEXA SKILL MANAGEMENT FUNCTIONS - END
**********************************************************************************/

def codeUpdatesPage() {
    dynamicPage(name: "codeUpdatesPage", uninstall: false, install: false) {
        def theURL = "https://consigliere-regional.api.smartthings.com/?redirect=" + URLEncoder.encode(getAppEndpointUrl("stupdate"))
        // log.debug theURL
        section() {
            def lamData = atomicState?.lambdaData
            def lDes = "\bStack Info:"
        //    lDes += "\n • Stack Version: (${lamData?.stackVersion != null ? lamData?.stackVersion : "N/A"})"
        //    lDes += "\n • Lambda Version: (${lamData?.version != null ? "V${lamData?.version}" : "N/A"})"
        //    lDes += "\n • Lambda Date: (${lamData?.versionDt != null ? "${lamData?.versionDt}" : "N/A"})"
            lDes += "\n\n\bSmartApps:"
            lDes += "\n • Parent Version: (${release() ?: "N/A"})"
            lDes += "\n • Profile Module: (${atomicState?.swVer?.profVer != null ? atomicState?.swVer?.profVer : "N/A"})"
            lDes += "\n • Shortcuts Module: (${atomicState?.swVer?.shrtCutVer != null ? atomicState?.swVer?.shrtCutVer : "N/A"})"
        //    lDes += "\n • Storage Module: (${atomicState?.swVer?.storVer != null ? atomicState?.swVer?.storVer : "N/A"})"
            paragraph lDes, state: "complete"
        }
        section() {
            paragraph title: "What will this do?", "This process makes sure the following are up-to-date:\n • Lambda\n • Skills(Not Yet)\n • All SmartApps\n\nAll you will need to do is sign in to the IDE and watch it go..."
            href url: theURL, title: "Tap to Update", description: null, image: getAppImg("es5_update.png")
        }
        section() {
			href "changeLogPage", title: "View Changelog", description: "", image: getAppImg("new.png")
		}
    }
}

def changeLogPage () {
	dynamicPage(name: "changeLogPage", title: "", nextPage: "mainPage", install: false) {
		section() {
			paragraph title: "What's New in this Release...", "", state: "complete", image: getAppImg("new.png")
			paragraph chgLogInfo()
		}
		def iData = atomicState?.installData
		iData["shownChgLog"] = true
		atomicState?.installData = iData
	}
}

def chgLogInfo() { return getWebData([uri: changeLogUrl(), contentType: "text/plain; charset=UTF-8"], "changelog") }

def getWebData(params, desc, text=true) {
	try {
		LogAction("getWebData: ${desc} data", "info", true)
		httpGet(params) { resp ->
			if(resp.data) {
				if(text) {
					return resp?.data?.text.toString()
				} else { return resp?.data }
			}
		}
	}
	catch (ex) {
		if(ex instanceof groovyx.net.http.HttpResponseException) {
			LogAction("${desc} file not found", "warn", true)
		} else {
			log.error "getWebData(params: $params, desc: $desc, text: $text) Exception:", ex
		}
		return "${label} info not found"
	}
}


def storageInfoSect() {
    def storApp = getStorageApp()
    section("Storage App Info:") {
        if(storApp) {
            def str = ""
            str += "Version: V${storApp?.releaseVer()}"
            str += "\nUsage: ${storApp?.getStateSizePerc()}%"
            paragraph str, state: "complete"
        } else {
            paragraph "Error: Storage SmartApp Is Not Installed...", required: true, state: null
        }
    }
}

def getSkillDesc() {
	def sData = atomicState?.skillVendorData
    def locale = getSkillLocale()
    def str = ""
    if(sData?.size()) {
        def cnt = sData?.size() ?: 0
        def customSkills = sData?.findAll { !it?.nameByLocale[locale]?.toString() == "EchoSistant - ${settings?.defaultInvocation}" || !it?.nameByLocale[locale]?.toString() == "EchoSistant - Here" }
        str += customSkills?.size() ? "${str == "" ? "" : "\n"} • Custom Skills: (${customSkills?.size()})" : ""
    }
    return str == "" ? null : str
}

def getSkillLocale() {
    return settings?.awsLocale == "UK" ? "en-GB" : "en-US"
}

void settingRemove(name) {
	if(name) { app?.deleteSetting("$name") }
}

def getProfileApps() {
    List profApps = getChildApps().label 
//    log.warn "getProfileApps is: $profApps"
    if(profApps?.size()) {
        return profApps
    } else { return null }
}

def isPluralString(obj) {
	return (obj?.size() > 1) ? "(s)" : ""
}

def newLine(str) {
    return (str != "" ? "\n":"")
}

def LogAction(msg, type="debug", showAlways=false, logSrc=null) {
	def isDbg = appDebug ? true : false
	def theLogSrc = (logSrc == null) ? (parent ? "Automation" : "Manager") : logSrc
	if(showAlways) { Logger(msg, type, theLogSrc) }
	else if(isDbg && !showAlways) { Logger(msg, type, theLogSrc) }
}

def Logger(msg, type, logSrc=null, noSTlogger=false) {
	if(msg && type) {
		def themsg = "${msg}"
		if(!noSTlogger) {
			switch(type) {
				case "debug":
					log.debug "${themsg}"
					break
				case "info":
					log.info "||| ${themsg}"
					break
				case "trace":
					log.trace "| ${themsg}"
					break
				case "error":
					log.error "| ${themsg}"
					break
				case "warn":
					log.warn "|| ${themsg}"
					break
				default:
					log.debug "${themsg}"
					break
			}
		}
		//log.debug "Logger remDiagTest: $msg | $type | $logSrc"
	}
	else { log.error "Logger Error - type: ${type} | msg: ${msg} | logSrc: ${logSrc}" }
}

def getDtNow() {
    def now = new Date()
    return formatDt(now)
}

def getTimeOfDayDesc(desc=false) {
    def time = time2Str(now(), false, "HH:mm")
    if(time) {
        if(timeOfDayIsBetween("22:00", "05:59", time, location.timeZone)) { return !desc ? "Night" : "Tonight" }
        else if(timeOfDayIsBetween("06:00", "11:59", time, location.timeZone)) { return !desc ? "Morning" : "this Morning" }
        else if(timeOfDayIsBetween("12:00", "14:59", time, location.timeZone)) { return !desc ? "Afternoon" : "this Afternoon" }
        else if(timeOfDayIsBetween("19:00", "21:59", time, location.timeZone)) { return !desc ? "Evening" : "this Evening" }
        else { return !desc ? "Day" : "Today" }
    }
}

def prettyDt(dt, pfmt=null) {
    if(!dt) { return null }
    def newDt = Date.parse(pfmt ? pfmt : "E MMM dd HH:mm:ss z yyyy", dt)
    def dFor = new SimpleDateFormat("d");
    def mFor = new SimpleDateFormat("MMM");
    def tFor = new SimpleDateFormat("h:mm a");
    if(location?.timeZone) {
        dFor.setTimeZone(location?.timeZone)
        mFor.setTimeZone(location?.timeZone)
        tFor.setTimeZone(location?.timeZone)
    }
    return "${mFor.format(newDt)} ${dFor.format(newDt)}${getDaySuff(dFor.format(newDt)?.toInteger())} at ${tFor.format(newDt)}"
}

def formatDt(dt) {
    def tf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy")
    if(location?.timeZone) { tf.setTimeZone(location?.timeZone) }
    else {
        log.warn "SmartThings TimeZone is not set; Please open your ST location and Press Save"
    }
    return tf.format(dt)
}

private String getDaySuff(int day) {
    if (day >= 11 && day <= 13) {
      return "th";
    }
    switch (day % 10) {
    case 1:
      return "st";
    case 2:
      return "nd";
    case 3:
      return "rd";
    default:
      return "th";
    }
}

def getSkillInvoc(name) {
    return name?.replace("EchoSistant - ", "")
}




/************************************************************************************************************
           UI - Version/Copyright/Information/Help
************************************************************************************************************/
def appName() { return "EchoSistant Evolution" }
def childProfileName() { return "EchoSistant Rooms Dev" }
def storageAppName() { return "ES-Storage" }
def childNameSpace() { return "Echo" }
def gitRepo() { return "BamaRayne/Echosistant"}
def gitPath() { return "${gitRepo()}/${gitBranch()}"}
def gitBranch() { return "master" }
def relType() { return "Alpha (RC3)" }
def getAppImg(file)	    { return "https://raw.githubusercontent.com/tonesto7/SmartThings-tonesto7-public/master/resources/es5_content/images/$file" }
def getAppVideo(file)	{ return "https://raw.githubusercontent.com/tonesto7/SmartThings-tonesto7-public/master/resources/es5_content/videos/$file" }
def getFirebaseAppUrl() 	{ return "https://echosistant-analytics.firebaseio.com" }
def getStackTemplateUrl() 	{ return "https://s3.amazonaws.com/echosistant/EchoSistantHelper.template" }
def getStackName() 			{ return "EchoSistantHelper" }
def getStackInstallUrl() { return "https://console.aws.amazon.com/cloudformation/home#/stacks/create/review?templateURL=${getStackTemplateUrl()}&stackName=${getStackName()}&param_appEndPointUrl=" }
def awsSkillAuthUrl() { return "https://www.amazon.com/ap/oa?response_type=code&client_id=amzn1.application-oa2-client.aad322b5faab44b980c8f87f94fbac56&redirect_uri=https%3A%2F%2Fs3.amazonaws.com%2Fask-cli%2Fresponse_parser.html&scope=alexa%3A%3Aask%3Askills%3Areadwrite%20alexa%3A%3Aask%3Amodels%3Areadwrite%20alexa%3A%3Aask%3Askills%3Atest&state=Ask-SkillModel-ReadWrite " }
def getAppEndpointUrl(subPath)	{ return "${apiServerUrl("/api/smartapps/installations/${app.id}${subPath ? "/${subPath}" : ""}?access_token=${atomicState.accessToken}")}" }
def getWikiPageUrl()	{ return "http://thingsthataresmart.wiki/index.php?title=EchoSistant" }
def appDataUrl()        { return "https://raw.githubusercontent.com/tonesto7/app-icons/master/appData.json"}
def changeLogUrl()      { return "https://raw.githubusercontent.com/tonesto7/SmartThings-tonesto7-public/master/resources/es5_content/changelog.txt" }
def getIssuePageUrl()	{ return "https://github.com/BamaRayne/echosistant/issues" }
def appInfoDesc()	{
    def str = ""
    str += "${appName()}"
    str += relType() != "" ? "\n • Release: ${relType()}" : ""
    str += "\n • ${textVersion()}"
    str += "\n • ${textModified()}"
    return str
}

def pluralize(str, cnt) {return "$str${(cnt>1 && !str?.endsWith("s")) ? "s":""}"}

def cleanSsml(str) {return str.replaceAll(/\<[^\>]*\>/, "") }

def getRandomItem(items) {
    def list = new ArrayList<String>();
    items?.each { list?.add(it) }
    return list?.get(new Random().nextInt(list?.size()));
}


def clearActionMaint() {
    settingRemove("clearActionMaint")
    atomicState?.actionMaintInProg = null
    atomicState?.actionMaintPassCnt = null
    atomicState?.actionMaintStartDt = null
    atomicState?.actionMaintItems = null
    atomicState?.actionMaintResults = null
    atomicState?.appMaintInProg = false
    atomicState?.profClnRoomNames = null
}

void actionMaintCheck(data) {
    def actType = data?.actType
    def actItems = atomicState?.actionMaintItems
    def addPass = (data?.addPass == true)
    def actTypeCap = data?.actType?.toString().capitalize()
    if(!actItems?.crt?.size() && !actItems?.rem?.size() && !actItems?.upd?.size()) {
        atomicState?.actionMaintInProg = false
        def strtDt = atomicState?.actionMaintStartDt ?: now()
        def passCnt = atomicState?.actionMaintPassCnt
        if(atomicState?.skillRemovalInProg) { 
            atomicState?.skillVendorData = null 
            atomicState?.skillRemovalInProg = false
        }
        LogAction("${actTypeCap} Maintenance Finished | Process Took (${passCnt ?: 1} Pass${passCnt>1 ? "es" : ""}) and (${((now()-strtDt)/1000).toDouble().round(2)}sec) to Complete", "info",true)
        atomicState?.actionMaintStartDt = null
        atomicState?.actionMaintPassCnt = 0
    //    schedLambdaStatusUpd(30, " | (Profile Maintenance)", true)
    } else {
        if(actType == "skill" && atomicState?.actionMaintPassCnt > 50) { 
            atomicState?.actionMaintInProg = false
            return
        }
        atomicState.actionMaintInProg = true
        if(actType == "profile") { 
            atomicState?.appMaintInProg = true
            lambaDevStateUpdReq(false) 
            unschedule("sendLambdaStatusUpdate")
        }
        if(addPass != true) {
            atomicState?.actionMaintPassCnt = 1
            atomicState?.actionMaintStartDt = now()
        }
        else { atomicState?.actionMaintPassCnt = atomicState?.actionMaintPassCnt + 1 }
        def passCnt = atomicState?.actionMaintPassCnt
        LogAction("actionMaintCheck: (Action: ${actType} | InProg: ${atomicState?.actionMaintInProg}) | FollowUpPass: (${addPass ? "Pass#: ${passCnt}" : "No"}) | Remove: (${actItems?.rem?.size() ?: 0}) | Update: (${actItems?.upd?.size() ?: 0}) | Create: (${actItems?.crt?.size() ?: 0})","debug", true)
        def passDesc = addPass ? "Continuing" : "Starting"
        if(actType == "profile") {
            if(actItems?.rem?.size() || actItems?.upd?.size()) {
                LogAction("${passDesc} Profile Maint Remove/Update (Pass: ${passCnt}) | Pending Removal: (${actItems?.rem?.size() ?: 0}) | Pending Update: (${actItems?.upd?.size() ?: 0})","trace", true)
                runIn(4, "remOrUpdProfiles", [overwrite: true, data:[actType: actType]])
            } else {
                if(actItems?.crt?.size()) {
                    LogAction("${passDesc} Profile Maint Create (Pass: ${passCnt}) | Pending Creation: (${actItems?.crt?.size() ?: 0})","trace", true)
                    runIn(4, "createProfiles", [overwrite: true, data:[actType: actType]])
                }
            }
        } else { 
            if(actItems?.rem?.size()) {
                LogAction("${passDesc} Skill Removal (Pass: ${passCnt}) | Pending Removal: (${actItems?.rem?.size() ?: 0})","trace", true)
                runIn(2, "procSkillRemoval", [overwrite: true, data:[actType: actType]])
            } else if(actItems?.crt?.size()) {
                LogAction("${passDesc} Skill Creation (Pass: ${passCnt}) | Pending Creation: (${actItems?.crt?.size() ?: 0})","trace", true)
                runIn(2, "procSkillCreate", [overwrite: true, data:[actType: actType]])
            } else if(actItems?.upd?.size()) {
                LogAction("${passDesc} Skill Update (Pass: ${passCnt}) | Pending Update: (${actItems?.upd?.size() ?: 0})","trace", true)
                runIn(2, "procSkillUpdate", [overwrite: true, data:[actType: actType]])
            }
        }
    }
}

  
