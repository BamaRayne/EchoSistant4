/* 
 * EchoSistant v4.6 - Control and Feedback of your Smart Things Environment via Natural Conversations with Alexa.
 
 
 ************************************ FOR INTERNAL USE ONLY ******************************************************
							
 								DON'T FORGET TO UPDATE RELEASE NUMBER!!!!!
 
 ************************************ FOR INTERNAL USE ONLY ******************************************************

 *		12/21/2018	Version: 4.6 R.0.0.3	UI Changes and bug fix in WebCoRE Piston execution	
 *		12/18/2018 	Version: 4.6 R.0.0.2e	Bug fix in SHM announcements and addition of optional restore volume on Alexa Devices, UI updates	
 *		12/18/2018 	Version: 4.6 R.0.0.2d	Bug fix
 *		12/16/2018 	Version: 4.6 R.0.0.2C	Addidtion of system defaults page
 *		12/06/2018 	Version: 4.6 R.0.0.2b	Small changes and updates
 *		12/01/2018 	Version: 4.6 R.0.0.2a	Moved donations to opening page
 *		11/27/2018 	Version: 4.6 R.0.0.2		Bug fix in ST token generation and code clean up
 *		11/23/2018 	Version: 4.6 R.0.0.1		Version change and release
 *		10/26/2018 	Version: 4.5 R.0.0.2		Re-Release
 *
 *  Copyright 2018 Jason Headley & Bobby Dobrescu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 * //UPDATE VERSION
/**********************************************************************************************************************************************/
import groovy.json.*
import java.text.SimpleDateFormat
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import java.security.InvalidKeyException
import java.security.MessageDigest

include 'asynchttp_v1'

private getCookie1()		{'x-amzn-dat-gui-client-v=1.24.204639.0; ubid-main=131-7721443-4641520; aws-priv=eyJ2IjoxLCJldSI6MCwic3QiOjB9; aws_lang=en; aws-target-static-id=1542261201932-401640; aws-target-data=%7B%22support%22%3A%221%22%7D; s_fid=71CBCA33CE7FA349-19F62F662962C2A1; s_cc=true; aws-target-visitor-id=1542261201938-191418.17_3; aws-mkto-trk=id%3A112-TZM-766%26token%3A_mch-aws.amazon.com-1542261203365-80611; aws-ubid-main=654-7823710-7463113; aws-session-id=134-3387195-2310728; aws-session-id-time=2172981212l; __utmc=194891197; regStatus=registered; skin=noskin; csrf=263391999; x-wl-uid=1XclIHw1DMDdUtME2gEGCgLzFmdHlUu3ZOs1ctRWjaD0p6S6Rw30sUZfzgPnOVK2hpEZhANjXNgzycq7dkloJ6sqADT5ps95EhXHMtdbLPkBbOsod9ZRhMeuUFmdiIXM/M0isOabiP3k=; appstore-devportal-locale=en_US; AMCVS_4A8581745834114C0A495E2B%40AdobeOrg=1; lc-main=en_US; _mkto_trk=id:365-EFI-026&token:_mch-amazon.com-1543772030669-64880; c_m=undefinedwww.google.comSearch%20Engine; s_ppv=66; __utma=194891197.562564648.1542261212.1544464146.1544507352.17; __utmz=194891197.1544507352.17.17.utmccn=(referral)|utmcsr=console.aws.amazon.com|utmcct=/lambda/home|utmcmd=referral; aws-session-token="/wTTFkoyfTn3mSfwBDcXyJZp1OLh1OxoO+P6ePLu5/pqFrd03d/bLQwZ8xrr+7dHlye7WJLZm9tx2QUvflWiViiNAI0FYpRKqud3uR0xUNxoQL8BNApeN7NjxwjlBv8co+tWT+ZROjKhYBZSGW4iPTt9QiRa0XeJfHAAAt8JZRUgY4OAhicUcBK+MjU7SH85IdP38yrHgQJM6weuSBP8GVE8geQwnR165CLgY2vNJyM="; aws-x-main="j?Cufo?r9fYFIwMwCcHBnJt6kWm3lyMv"; aws-at-main=Atza|IwEBIN2LNzYd89OfvD75Eq_nfd9Frs2JKLYncDP42CPakimFFYdZyaMm2hvqHCLQv_SNJvy2eYs91w5cYmkSqyA_seHb7WmvY8-IIK_NEx3jbA3bVxKt6lMJ-exMxs-yiLb_01RivVm5KDs7Qdp7ew4jgS0O0B-LJLzR_9hxLyN-7JGK2eitYSBbZ3o2apiNJAclocxTSjfUQv8NPQFtDgDypeKwCiEuMymWXqaOANx0Mkat-rvfHd3XpMhH0YysgkCXqlxO5KX6GlmTGWSoZgf5ArRXv-Qk3bwL3qPYWW-e4dYnAfUmgcQKlzlldiZdeHM2B6I8h5GZus6Uv8R7pvauexrqlud1ii938CaMU2S4J4yOnnVuN3R_jz4iwOi2pjV2te_0YWIaU_xu-wdNIxrQUKkpOzuCLX9XnoGF1CLlqfx5dA; sess-aws-at-main="1vhmRkUynFte1iowly/2aHnK2v8w6oMb+l7GFiPuwZw="; aws-userInfo=%7B%22arn%22%3A%22arn%3Aaws%3Aiam%3A%3A539060706355%3Aroot%22%2C%22alias%22%3A%22%22%2C%22username%22%3A%22Jason%2520%2526%2520Wendi%2520Headley%22%2C%22keybase%22%3A%224qIs49Ojw6M%2BFhhlcFe3nkXqnv4kivpxPgvVJg3sAEU%5Cu003d%22%2C%22issuer%22%3A%22https%3A%2F%2Fwww.amazon.com%2Fap%2Fsignin%22%7D; s_sq=%5B%5BB%5D%5D; s_vn=1573797202815%26vn%3D25; AMCV_4A8581745834114C0A495E2B%40AdobeOrg=-1303530583%7CMCIDTS%7C17877%7CMCMID%7C51829742398602435107401571880167397504%7CMCOPTOUT-1544519003s%7CNONE%7CMCAID%7CNONE%7CvVersion%7C3.3.0; referrer_session={%22full_referrer%22:%22https://www.google.com/%22}; s_lv=1544520024761; sst-main=Sst1|PQE-VvKkJOK4GquAGlxIw7N4CyktGpo6iF2iA1pucqz6cdyulE1VSHZCmiMNd6L0j4NW36jiGLRgsZ0rCePGD24fHRzXo8WDsXF7p4UZ54o4925eMfa2aESO6L2rGj-RL4E83iePtpV6X2A7ndrxuae7fzjXsWnMuDMclgnc4B_hVqckNFx8XAXYgrqt721hTnlwZHPqMJsKoO51CYaryftPFnOJZqCqDF3gtwUB9ufUm5gYfx15eKSWsS_cu0DAzTwvGwzOdu2kMHvm0bgmejOdVblF4JqVtkeCPsKdXq2-K4qZDVANhZx68yIiptn7cNG1u49_v6xg99zscI7q8ID8bQ; s_nr=1544920902934-Repeat; s_vnum=1976456422174%26vn%3D3; s_dslv=1544920902938; session-id=142-4471920-3375238; session-id-time=2175672646l; session-token="bfN6clI0cm1y1xVpACPjgUf5EZv7apbCKeVRb4EPh/DehSuS5DUYESWwKg/peM2gDW2VAjfBMZxHGID7cKskqbRy1wmJB29KjgfC98ZTLBuAdFpY4QjiknHirGI8X1sfQEOkGUA9edfwa8dxMDcvSStHzJ2qHq0aB7Z0iXuVyiZNZbpXCVOnCtzfasOAQ25tmY7n2AodyeXn6EzEPg7vX6sHOJwV7z4AlQxwD1yqye0="; x-main=f0p0hCcxd50aCf76YgfwvP2yMeroLDzw; at-main=Atza|IwEBIFndgX5GqSt4frCbDFGZqbrnasGduoo57Uh5BbqWBS5PlAIZ6v6QEKv-zQ5dPumODKbI3PZBAFjU-D-Ufy6PwuiuSZJqoj4M_wA8SZXVE2vZPhBEOql1Owe1D_MbvpF4aufvk2zoAzL2opDRfXaU5ul33NN88UgJQietoZH3aLR6iC64znq2V0cm3TCNVUGrvT2W0VhwPHlqfqCkof2vPPTmYQNUfA7iC-UBztDa-vPhKCv-uDx7Ru2FJGQ7q_9L8_QFUmXU9eLmVxfRwZeqOIFi3R2bIR04Bx0mZVuQBER2D1tv6gjzuK4s4WhXjr30jF-DuZnRDDfjL1O2oaSTS9_Z87Y0nyDGIAAoH3d-vyP543ZgYmxjh__gHW3aer_JOJxpUNjqqs-vr7An_5UpgfYC; sess-at-main="ICk5SRsCPK+2oB5bZ47vhUZskCN/chdw8jImecb8zXQ='}

definition(
	name			: "EchoSistant",
    namespace		: "Echo",
    author			: "JH/BD",
	description		: "Control and Feedback of your Smart Things Environment via Natural Conversations with Alexa.",
	category		: "My Apps",
    singleInstance	: false,
	iconUrl			: "https://raw.githubusercontent.com/BamaRayne/Echosistant/master/smartapps/bamarayne/echosistant.src/app-Echosistant.png",
	iconX2Url		: "https://raw.githubusercontent.com/BamaRayne/Echosistant/master/smartapps/bamarayne/echosistant.src/app-Echosistant@2x.png",
	iconX3Url		: "https://raw.githubusercontent.com/BamaRayne/Echosistant/master/smartapps/bamarayne/echosistant.src/app-Echosistant@2x.png")
{
	appSetting "cookie1"
}
/**********************************************************************************************************************************************
	UPDATE LINE 38 TO MATCH RECENT RELEASE
**********************************************************************************************************************************************/
private def textVersion() {
	def text = "1.0"
}
private release() {
    def text = "Version 4.6, Revision 0.0.3"
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
            href "mIntent", title: "Configure System Settings", description: mIntentD(), state: mIntentS(), 
            image: "https://raw.githubusercontent.com/BamaRayne/Echosistant/master/smartapps/bamarayne/echosistant.src/Echosistant_Config.png"
        }
        section ("DashBoard") {    
            paragraph "The Current Mode is: ${location.currentMode}"
            paragraph "Smart Home Monitor is set to: " + getSHMStatus()
        }
        section("Donations:") {
             href url: textDonateLink(), style:"external", required: false, title:"Donations", description:"Tap to open browser",
             image: "https://raw.githubusercontent.com/BamaRayne/SmartSuite/master/Icons/Donate.png"
        }
        section("Uninstall") {
        	href "uninstallPage", title: "Click here to remove $app.label", image:"https://raw.githubusercontent.com/jasonrwise77/My-SmartThings/master/LogicRulz%20Icons/uninstall.png"
        }
	}
}

// UNINSTALL PAGE
page name: "uninstallPage"
    def uninstallPage() {
    	dynamicPage (name: "uninstallPage", title: "Clicking on the BIG RED BUTTON below will completely remove $app.label and all Routines!", install: true, uninstall: true) {
    		section("Please ensure you are ready to take this step, there is no coming back from the brink!"){
            }
		}
    }    

page name: "mIntent"
def mIntent() {
    dynamicPage (name: "mIntent", title: "Settings and Support", install: false, uninstall: false) {
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
/*        section ("Fan Control") {            
            input "cHigh", "number", title: "Alexa Adjusts High Level to 99% by default", defaultValue: 99, required: false
            input "cMedium", "number", title: "Alexa Adjusts Medium Level to 66% by default", defaultValue: 66, required: false
            input "cLow", "number", title: "Alexa Adjusts Low Level to 33% by default", defaultValue: 33, required: false
            input "cFanLevel", "number", title: "Alexa Automatically Adjusts Ceiling Fans by using a scale of 1-100 (default is +/-33%)", defaultValue: 33, required: false
        }
*/       section ("Alexa Voice Settings") {            
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
        }
        section ("Weather Settings") {
            href "mWeatherConfig", title: "Tap here to configure the Weather defaults", description: "", state: complete
        }                     
*/    }
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
        	input "trace", "bool", title: "Enable Trace Logging", default: false, submitOnChange: true
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
mappings {
    path("/b") { action: [GET: "processBegin"]}
	path("/t") { action: [GET: "processTts"] }
    path("/renderAwsCopyText") { action: [GET: "renderAwsCopyText"] }
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
//	state.cookie = getCookie1()
        state.alexa = null
	    state.amazon = null
    	state.language = null
		webCoRE_init()
        //REMINDERS
		sendLocationEvent(name: "EchoSistant v4.5", value: "refresh", data: [profiles: getProfileList()] , isStateChange: true, descriptionText: "Reminders list refresh")
		//SHM status change and keypad initialize
    		subscribe(location, locationHandler)
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
			state.pendingConfirmation = false
}
def getProfileList(){
		return getChildApps()*.label
}


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
    def pPendingAns = false 
    def pContinue = state.pMuteAlexa
    def pShort = state.pShort
    def String outputTxt = (String) null 
    	state.pTryAgain = false
    if (debug) log.debug "^^^^____LAUNCH REQUEST___^^^^" 
    if (debug) log.debug "Launch Data: (event) = '${event}', (deviceId) = '${state.deviceId}', (Lambda version) = '${versionTxt}', (Lambda release) = '${releaseTxt}', (ST Main App release) = '${releaseSTtxt}'"

    if (event == "noAction") {
    	state.pinTry = null
        state.savedPINdata = null
        state.pContCmdsR = null 
        state.pTryAgain = false
}

log.debug "deviceID = $state.deviceId"

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
        log.debug "ptts = = $ptts"

	if (ptts.contains(" in the")) {
		ptts = ptts.replaceAll("\\bin the.*\\b","")
		}
			childApps.each {child ->
             	if (child.label.toLowerCase() == pintentName.toLowerCase()) { 
                    if (debug) log.debug "Found a profile: '${pintentName}'"
                    pintentName = child.label
                    // recording last message
                    state.lastMessage = ptts
                    state.lastIntent = pintentName
                    state.lastTime = new Date(now()).format("h:mm aa", location.timeZone)
                    dataSet = [ptts:ptts, pintentName:pintentName] 
					def childRelease = child.checkRelease()
					log.warn "childRelease = $childRelease"

					if (ptts.startsWith("did") || ptts.startsWith("tell") || ptts.startsWith("get") || ptts.endsWith("tonight") || ptts.contains("weather") || ptts.contains("temperature") || ptts.contains("forecast") || ptts.contains("humidity") || ptts.contains("rain") || ptts.contains("wind")) {
                    	def pResponse = child.profileFeedbackEvaluate(dataSet)
                        outputTxt = pResponse.outputTxt
                    	pContCmds = pResponse.pContCmds
                    	pContCmdsR = pResponse.pContCmdsR
                    	pTryAgain = pResponse.pTryAgain
                    	}
					if (ptts.startsWith("for") || ptts.startsWith("is") || ptts.startsWith("has") || ptts.startsWith("give") || ptts.startsWith("how") || ptts.startsWith("what") || ptts.startsWith("when") || ptts.startsWith("which") || ptts.startsWith("are") || ptts.startsWith("check") || ptts.startsWith("who")) {
                        def pResponse = child.profileFeedbackEvaluate(dataSet)
                        outputTxt = pResponse.outputTxt
                    	pContCmds = pResponse.pContCmds
                    	pContCmdsR = pResponse.pContCmdsR
                    	pTryAgain = pResponse.pTryAgain
                    	}
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
/*    def newTts = ptts.split("and").each { t -> 
    	ptts = t.toLowerCase() 
         
            if (!ptts.contains(" in the")) {
             	def test = "$params.intentName"
                test = test as String
                def pintentName = "$test"
                ptts = ptts.replaceAll("\\band.*\\b", "")
                log.trace "the ptts is: $ptts"
                log.trace "the pintentName is: $pintentName"
				def data = [ptts:ptts, pintentName:pintentName] 
           //     outputTxt = findChild(data)
             	}
             
             if (ptts.contains(" in the")) {
             	def test = ptts.replaceAll("\\b.*in the \\b","")
                test = test as String
                def pintentName = "$test"
                ptts = ptts.replaceAll("\\bin the.*\\b", "")
                log.trace "new ptts is: $ptts"
                log.trace "new pintentName is: $pintentName"
				def data = [ptts:ptts, pintentName:pintentName] 
             //   findChild(data)
                }*/
                
    

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




page name: "echoDevicePage"    
def echoDevicePage(){
    dynamicPage(name: "echoDevicePage", title: "",install: false, uninstall: false) {

//    page(name: "pageOne", title: "Alexa Cookie and Country selections", nextPage: "pageTwo", uninstall: true) {
//        section("Please Enter your alexa.amazon.com 'cookie' file string here (end with a semicolon)") {
//            input("cookie", "text", required: false, defaultValue: 'x-amzn-dat-gui-client-v=1.24.204141.0; aws-ubid-main=477-6886115-7675244; aws-target-static-id=1515155664508-989184; aws-target-data=%7B%22support%22%3A%221%22%7D; s_fid=1D31599F9475125F-0898CD44D8C8C08C; aws-session-id=146-2329803-0212767; aws-session-id-time=2145875692l; regStatus=registered; csrf=814714357; aws-business-metrics-last-visit=1516845127502; __utmv=194891197.%22YiWFB4zpVGcpJ0y18erh8qdqNdKFS1%3FW%22; ubid-main=132-4757015-2246050; _mkto_trk=id:365-EFI-026&token:_mch-amazon.com-1527203055432-78078; skin=noskin; __utmc=194891197; AMCVS_4A8581745834114C0A495E2B%40AdobeOrg=1; s_cc=true; appstore-devportal-locale=en_US; aws-priv=eyJ2IjoxLCJldSI6MCwic3QiOjB9; aws_lang=en; x-wl-uid=1DWi+rNdXVs934+6s2RP2eZkHKHiB67VwNLMmvMwzbn9hk5tOf53pBAA0yapZTDeaDGQqtKU3CPZxk9FdFRHA3H/dNeIl19LlE5NYjhIutYNvBo7Qvesh7TioEikKh9o3iwcaoZHhWXc=; session-id=140-7292554-3767924; session-id-time=2082787201l; sid="VT2sqKz4J2Fkp+wtVCKsKA==|k1Va+I5/Gx12T4wYla2xr5APc2sADG6t3Op4BOlOxG0="; aws-mkto-trk=id%3A112-TZM-766%26token%3A_mch-amazon.com-1527203055432-78078; s_evar1=chat; s_ev22=%5B%5B%27chat%27%2C%271537064469196%27%5D%5D; lc-main=en_US; s_vnum=1958337005567%26vn%3D9; s_ppv=64; sst-main=Sst1|PQHB7Mvf7f72fU1mp0vk73mQC-HohapiyfFVrGDb6Z8MifgALMbG1JLU2nphDBJ8H1mJ1hJglPRh76_9FEUZnYoMRosJtiwCVNPQjnYlc_LKWyoo1lB7zrpJuQ2S0BDUuwjNL3Gj3yvX2PfOp5jhC_0nxcwVyxqDNG1eCplhFGw9TrXH_ApJzJ_yV1RxW9AGpAF8rn3XIBkOWUou9Hz2BQpLcA2pTkEmLQ6on3TyvClRhkIlEYoFGNPGGxvZtS4N6Tb6gSJ42vlZ2eOhqs8byuXORyqzIW6JzYLcYu26OkfwmrEdRdMVW3piDcrOYDLPGcecPLk-MYGqq6PDz0M_Nh7Vhg; aws-target-visitor-id=1515155664513-662159.28_32; AMCV_4A8581745834114C0A495E2B%40AdobeOrg=-330454231%7CMCIDTS%7C17817%7CMCMID%7C17922887831233164530867876419254160062%7CMCOPTOUT-1539313770s%7CNONE%7CMCAID%7CNONE%7CvVersion%7C3.1.2; s_vn=1546691665435%26vn%3D45; s_dslv=1539310084516; __utma=194891197.379500693.1515126610.1539196960.1539310087.81; __utmz=194891197.1539310087.81.53.utmccn=(referral)|utmcsr=console.aws.amazon.com|utmcct=/console/home|utmcmd=referral; aws-session-token="Qif/WTUCsPEhj8LmFoTra9NHztUqgsnrnS4KF3kZtf2yHTy/oHfUl7kS7yYpPqpbfkg/D+CXIgxmt8fU7j5/zX3/lWIcvu2iBn2OPYJLvxOkrUd4JgmzYXnM03t3D+1sSkpG2wKPVSd8Ei5T7AbJLkfTKITRbz79g4RTPRsqYMWXd8OzfJgh5dSTdmvDN+O72SCKirZnotssXRsNb2eqFwhLIQ6VpViEZvYs+Zcsvd0="; aws-x-main="ge?wSZGvjHxTLM9cr4lr5G1yfjtEyRPF"; aws-at-main=Atza|IwEBIJFwWL-1gXXTVU4cqAyQYj2L56Rn1R5TtDRsp-EbQ599WdprIax1AsJguelabRRhSS1SytqaE6kMPQZhbjpPVIaxgvaxIpgyWxTHEgpNthuEIHu0KDkQ8N87IIPiI6bxwMUOJM5U9XwF_z61Om_dLJGUT0RnDCPQ_XhoN7PTOdyFWQuANOCoKxDEsw39jFKk6Jm_SRoxViSM9vOSoxaQoQ9SAtIzfzZYnB_nXioZbjcd2c42QnSfBX-lR5_ZWjC3fgu3ktR6LHJpQpKWBciHX5RkFPXao8gzjny8z09ufeZML4VbHHbgJ3CwuKIqFgo2dqFpbmHIJHcvcEg7R5uOjKvHwLfy3MFXN4v4O7mdVYE_0nMrRlh1xNCWYnsm0Q9wcXaq8I0PEa5PBMBke0aBX7B3goQtyDXXe8v0d7Wwh7d_ww; sess-aws-at-main="7twIGTwXGmldITyDLIRa7aASKd3FP+P8Es9VdYMnmUw="; aws-userInfo=%7B%22arn%22%3A%22arn%3Aaws%3Aiam%3A%3A539060706355%3Aroot%22%2C%22alias%22%3A%22%22%2C%22username%22%3A%22Jason%2520%2526%2520Wendi%2520Headley%22%2C%22keybase%22%3A%22RDl9D6TsC6KdkZP7wkHuMwbvhSzOjsGt7vyqOm%2BusEY%5Cu003d%22%2C%22issuer%22%3A%22https%3A%2F%2Fwww.amazon.com%2Fap%2Fsignin%22%7D; referrer_session={%22full_referrer%22:%22https://developer.amazon.com/alexa/console/ask/build/custom/amzn1.ask.skill.7330ab0e-bd9f-484f-a467-8f47a5c1df15/development/en_US/json-editor%22}; s_sq=amzna2z%3D%2526pid%253D%25252Falexa%25252Fconsole%25252Fask%2526pidt%253D1%2526oid%253Dfunction%252528%252529%25257BdismissNotification%252528toast%252529%25253B%25257D%2526oidt%253D2%2526ot%253DI; s_nr=1539310743578-Repeat; s_lv=1539310743580; x-main="ewiuc2K0tnTUENKZWaDE3v4Vrt9@@PLc"; at-main=Atza|IwEBIGneWTg2NuDrzTCceZy0wtbzoqnhs7HX6fNZKwzcYAr85RO1ypr5f94au3-pPN-jerkgA4buCcbHOSOEcfAQiQ9n6_NujsBPq3T8ZQOE7JZ0Lyx8oj13Y2tO2Isg5FimTv23UR5lRTWzS8i7W9tSKUaz6W8MTG5YeZjyUUez0486hqBaIndrQ6kqQ3AX4dUtmYwGyq6uXzimiIAC6dv5UZMQwsW61Ge3kknZbTdZOruy5yhaIrygVaKbRcYRvPDf5bCH-OkbCeRJDUljN3AS6CJcrv9Y-EOXovGs8ZlaU_ARbZMMHLnbM6_jfP7F60sn_U1oZznBpHz189VFxhiLtA7V9p_dKXP5CEs5GYwe90OYqwf6HgLZ3F4FISo2J2Bgx0ixVQTgao0qcH1GZapGGtJS; sess-at-main="c4ohCT+LQPwqCiwNB2XeBgSj7Xc3IJDYJc0RcYGtNo4="; session-token="V9Yht598R/zpqUh/wEvidvM6fUN054KgVTj6a6vPqYO82uicTkbsF6nBbhf5nIbDYSo78up+3V+wj69upeFwI3OGbDainO0hAi2YWGICnQ6UxZbbw5siWSuX8pEgxB1TTKHqgHkWUDIJsuNC+hCI5WtE0/pblEKWED9bipV3ZY31EBy0pcwStWxtR1rUU2HN3s8FV2TkAmUcy+yYh3GJEA=='
//)
//        }
        section("Please choose your country and Amazon Domain") {
            input "alexaCountry", "enum", multiple: false, required: true, options: ["United States", "Canada", "United Kingdom"], default: "United States" 
        }
        section("Please select devices to create Alexa TTS child devices for") {
            input "alexaDevices", "enum", multiple: true, required: false, options: getDevices()
        }  
    }
    }

def getDevices() {
    if ("${alexaCookie}" == null) {
        log.debug "No cookie yet"
        return}
    try{
        def alexaCookie = getCookie1() //+getCookie2()+getCookie3()+getCookie4()+getCookie5()+getCookie6()+getCookie7()+getCookie8()+getCookie9()+getCookie10()+getCookie11()+getCookie12()

        def csrf = (alexaCookie =~ "csrf=(.*?);")[0][1]
        def params = [uri: "https://alexa.amazon.com/api/devices-v2/device?cached=false",
                      headers: ["Cookie":"""${alexaCookie}""",
                                "Referer": "https://getAmazon()/spa/index.html",
                                "Origin": "https://getAmazon()",
                                "csrf": "${csrf}",
                                "Connection": "keep-alive",
                                "DNT":"1"],
                      requestContentType: "application/json; charset=UTF-8"
                     ]
        httpGet(params) { resp ->
            if ((resp.status == 200) && (resp.contentType == "application/json")) {
                def validDevices = []
                atomicState.alexaJSON = resp.data
                //log.debug state.alexaJSON.devices.accountName
                atomicState.alexaJSON.devices.each {it->
                    if (it.deviceFamily in ["ECHO", "ROOK", "KNIGHT", "THIRD_PARTY_AVS_SONOS_BOOTLEG", "TABLET"]) {
                        //log.debug "${it.accountName} is valid"
                        validDevices << it.accountName
                    }
                    if (it.deviceFamily == "THIRD_PARTY_AVS_MEDIA_DISPLAY" && it.capabilities.contains("AUDIBLE")) {
                        validDevices << it.accountName
                    }
                }
                state.AlexaDevices = validDevices
                return validDevices
            }
            else {
                log.error "Encountered an error. http resp.status = '${resp.status}'. http resp.contentType = '${resp.contentType}'. Should be '200' and 'application/json'. Check your cookie string!"
                return "error"
            }
        }
    }
    catch (e) {
        //    log.error "httpGet() error = ${e}"
    }
}

def getAlexa() {
    switch ("${alexaCountry}") {
        case "United States": 
                return "pitangui.amazon.com"
            break
        case "Canada": 
                return "alexa.amazon.ca"
            break
        case "United Kingdom": 
                return "layla.amazon.co.uk"
            break
        default: 
            log.error "getAlexa Unknown country = ${alexaCountry}"
    }
    return "error: Unknown country"
}

def getAmazon() {
    switch ("${alexaCountry}") {
        case "United States":
                return "alexa.amazon.com" 
            break
        case "Canada": 
                return "alexa.amazon.ca"
             break
        case "United Kingdom": 
                return "amazon.co.uk" 
           break
//        default: 
//            log.error "getAmazon Unknown country = ${alexaCountry}"
    }
    return //"error: Unknown country"
}

def getLanguage() {
    switch ("${alexaCountry}") {
        case "United States":
                return "en-US"
            break
        case "Canada": 
                return "en-US"
            break
        case "United Kingdom": 
                return "en-GB"
            break
        default: 
            log.error "getLanguage Unknown country = ${alexaCountry}"
    }
    return "error: Unknown country"
}