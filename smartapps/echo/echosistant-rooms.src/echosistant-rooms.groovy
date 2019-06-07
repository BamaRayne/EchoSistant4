/* 
* EchoSistant Rooms Profile - EchoSistant Add-on
*
*		06/07/2019		Version:5.0 R.0.0.15	Added restrictions check for weather alerts
*		06/06/2019		Version:5.0 R.0.0.14	Minor bug fixes and tweaks to different things
*		05/23/2019		Version:5.0 R.0.0.13	Added ability to ask when a contact status was last changed, and when a person last arrived/departed
*		04/21/2019		Version:5.0 R.0.0.12	Bug fix when asking WHAT in feedback. Added "Tell me about the xxx devices"
*		04/20/2019		Version:5.0	R.0.0.11	Updated and fixed bugs in weather alerts.
*		04/13/2019		Version:5.0 R.0.0.10	Added weather alert checks every 15 minutes and ability to ask for a weather alert 
*		03/14/2019		Version:5.0 R.0.0.9		Bug fix for returning a list of devices in feedback
*		03/09/2019		Version:5.0 R.0.0.8		Added Thermostats feedback
*		03/08/2019		Version:5.0 R.0.0.7		Added room control and feedback for televisions, fireplace, and garage doors
*		02/22/2019		Version:5.0 R.0.0.6		Bug fix for humidity and temperature when asking "What's the temperature/humidity"
*		01/27/2019		Version:5.0 R.0.0.5		Bug fix in color bulbs commands
*		01/16/2019		Version:5.0 R.0.0.4		Expanded command, delay, restore functions. Expanded music feature to play String on Pandora in the room
*		01/14/2019		Version:5.0 R.0.0.3		Added ability to start and stop music in rooms on Echo Speaks Devices
*		01/13/2019		Version:5.0 R.0.0.2		Bug fix in creating alarms and added ability to create alarms on mulitple echo devices
*		01/13/2019		Version:5.0 R.0.0.1b	Bug fix in color bulb (ind & groups) color changes
* 		01/12/2019		Version:5.0 R.0.0.1a	Licence update
*		01/11/2019		Version:5.0 R.0.0.1		Modification for integration into Version 5.0
*		01/09/2019		Version:4.6 R.0.3.7		Bug fix in scheduling
*		01/09/2019		Version:4.6 R.0.3.6		Added Verbal specific time scheduling to actions & ability to turn on/off device for xx minutes then restore
*		01/06/2019		Version:4.6 R.0.3.5		Improvements in the delay controls
*		01/03/2019		Version:4.6 R.0.3.4		Reformat of UI for simplification of app setup
*		01/02/2019		Version:4.6 R.0.3.3		Added ability to control individual automation/notification switches in group. 
												Added "What automations/notifications are on" to feedback
*		12/30/2018		Version:4.6 R.0.3.2		Minor bug fixes in command structure
*		12/28/2018		Version:4.6 R.0.3.1		More expansion on the Delay commands
*		12/27/2018		Version:4.6 R.0.3.0		Tweaking method to allow "Alexa, wake me up at 3:45 in the bedroom" type of commands.
*		12/24/2018		Version:4.6 R.0.2.9		Fixed bug in running Logic Blockz from Alexa
*		12/23/2018		Version:4.6 R.0.2.8		Fixed problem with adjusting dimmers group using Alexa Feels commands
*		12/22/2018		Version:4.6 R.0.2.7		Added audio notifications kill switches to control and feedback along with autorestore feature.
												Set room specific permissions for SHM arm/disarm
*		12/22/2018		Version:4.6 R.0.2.6		Rebuild of fans control to improve reliability
*		12/21/2018		Version:4.6 R.0.2.5		UI changes and WebCoRE Pistons execution bug fix
*		12/19/2018		Version:4.6 R.0.2.4		Bug fix for the bug fix for resetting the queue... my bad :)
*		12/19/2018		Version:4.6 R.0.2.3		Bug fix in resetting the queue of an Alexa device via Echo Speaks app and added feedback "are the automations on".
*		12/18/2018		Version:4.6 R.0.2.2		Added color control to color group as well as individual device color control
*		12/16/2018		Version:4.6 R.0.2.1		Bug fix in verbal command to reset queue of Alexa devices from Echo Speaks
*		12/15/2018		Version:4.6 R.0.2.0		Several bug fixes in logic, improvements in individual device commands, and upgrades to more accurate command feedback
*		12/10/2018		Version:4.6 R.0.1.9c	Bug fix for lights with strange names
*		12/08/2018		Version:4.6 R.0.1.9b	Bug fixes in logic
*		12/06/2018		Version:4.6 R.0.1.9a	Bug fixes and change of shortcuts to Logic Blocks
*		12/04/2018		Version:4.6 R.0.1.9		Complete rewrite of control section. Expanded compound commands and delays
*		12/01/2018		Version:4.6 R.0.1.8c	Bug fix in set volume and restore of Echo Devices
*		12/01/2018		Version:4.6 R.0.1.8b	Bug fix in motion detection feedback
*		12/01/2018		Version:4.6 R.0.1.8a	Bug fix for setting the SHM by saying turn on the alarm
*		12/01/2018		Version:4.6 R.0.1.8		Bug fix for feedback of devices
*		11/27/2018		Version:4.6 R.0.1.7		Added verbal execution of webcore pistons
*		11/25/2018		Version:4.6 R.0.1.6		Bug fixes. Additional feedback: Fan speeds, Dimmer levels
*		11/25/2018		Version:4.6 R.0.1.5		Bug fix for individual lights feedback
*		11/24/2018		Version:4.6 R.0.1.4		Completed code for compound devices and compound groups commands
*		11/23/2018		Version:4.6 R.0.1.3		Code Cleanup prep for release with Version Change
* 		11/21/2018		Version:4.5 R.0.1.2		Improved performance and outputs
*		11/19/2018		Version:4.5 R.0.1.1		Add in cancel of delay/timers
*		11/19/2018		Version:4.5 R.0.1.0		Add in delay timers, improved logic
*		11/18/2018		Version:4.5 R.0.0.9		Added individual device controls
*		11/16/2018		Version:4.5 R.0.0.8		Updates to the way things look in the app.
*		11/16/2018		Version:4.5 R.0.0.7		Complete overhaul of the freespeech engine. Compound commands added
*		11/09/2018		Version:4.5 R.0.0.6		Control update: added ability to set volume to a precise number
*		11/08/2018		Version:4.5 R.0.0.5		Feedback update: added Alexa Device capabilities, power meters
*		11/07/2018		Version:4.5 R.0.0.4		Feedback update: added ability to ask "Is the alarm on/off" also "Is the garage door open/closed"
*		10/26/2018		Version:4.5 R.0.0.3		Re-release
*		9/12/2018		Version:4.5 R.0.0.2		Rework for streamlining and added Echo Device selection
*		6/12/2017		Version:4.5 R.0.0.1		Alpha Release
*		2/17/2017		Version:4.0 R.0.0.1		Public Release
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
*
*  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
*  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
*  for the specific language governing permissions and limitations under the License.
*
/**********************************************************************************************************************************************/
import groovy.json.*
import java.text.SimpleDateFormat
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import java.security.InvalidKeyException
import java.security.MessageDigest
include 'asynchttp_v1'


definition(
	name			: "EchoSistant Rooms",
    namespace		: "Echo",
    author			: "JH/BD",
	description		: "EchoSistant Rooms - Custom rooms and Custom Control",
	category		: "",
    parent			: "Echo:EchoSistant",
	iconUrl			: "https://raw.githubusercontent.com/BamaRayne/Echosistant/master/smartapps/bamarayne/echosistant.src/app-Echosistant.png",
	iconX2Url		: "https://raw.githubusercontent.com/BamaRayne/Echosistant/master/smartapps/bamarayne/echosistant.src/app-Echosistant@2x.png",
	iconX3Url		: "https://raw.githubusercontent.com/BamaRayne/Echosistant/master/smartapps/bamarayne/echosistant.src/app-Echosistant@2x.png")
/**********************************************************************************************************************************************/
private release() {
	def text = "R.0.4.6"
}
private revision(text) {
	text = "Version 5.0, Revision 0.0.15"
    state.version = "${text}"
    return text
    }
/**********************************************************************************************************************************************/
preferences {

    page name: "mainProfilePage"
    page name: "messaging"
    page name: "feedback"
    page name: "shortcuts"
    page name: "LogicBlocks"   
    page name: "pTrackers"
    page name: "pRestrict"
    page name: "pSend"          
    page name: "pActions"
    page name: "cDevices"
    page name: "pDeviceControl"
    page name: "pPerson"
    page name: "pVirPerAction"
  	page name: "renamePage"
    page name: "reports"
}

// MAIN PROFILE - HOME PAGE
def mainProfilePage() {	
    dynamicPage(name: "mainProfilePage", title:"", install: true) {
        section ("") {
            label title:"Name this Room", required:true,
            image: "https://raw.githubusercontent.com/BamaRayne/SmartSuite/master/Icons/Name.jpg"
            }
        section("") {
            href "messaging", title: "Outgoing Messages", description: pSendComplete(), state: pSendSettings(),
            image: "https://raw.githubusercontent.com/BamaRayne/SmartSuite/master/Icons/Messages.png"
        	}
        section("") {
            href "cDevices", title: "System Controls and Feedback", description: pGroupComplete(), state: pGroupSettings(),
            image: "https://raw.githubusercontent.com/BamaRayne/SmartSuite/master/Icons/control panel.ico"
        }
        section("") {
            href "pActions", title: "Room Actions (Performed every time $app.label is activated)", description: pActionsComplete(), state: pActionsSettings(),
            image: "https://raw.githubusercontent.com/BamaRayne/SmartSuite/master/Icons/Action.png"
        }
        section("") {    
            href "LogicBlocks", title: "Logic Blocks and Reports", description: mRoomsDL(), state: mRoomsSL(),
            image:"https://raw.githubusercontent.com/jasonrwise77/My-SmartThings/master/LogicRulz%20Icons/Blok.png"
            }
        section ("") {
            href "pTrackers", title: "Task Trackers", description: pTrackComplete(), state: pTrackSettings(),
            image: "https://raw.githubusercontent.com/BamaRayne/SmartSuite/master/Icons/Taskers.png"
        }
        section ("") {
            href "pRestrict", title: "Action Restrictions", description: pRestrictComplete(), state: pRestrictSettings(),
            image: "https://raw.githubusercontent.com/BamaRayne/SmartSuite/master/Icons/Restrictions.png"
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

// OUTPUT MESSAGES HOME PAGE
page name: "messaging"
def messaging(){
    dynamicPage(name: "messaging", title: "Messaging Configuration", uninstall: false){    
        section("") {
            href "pSend", title: "Audio and Text Message Settings", description: pMsgComplete(), state: pMsgSettings(),
            image: "https://raw.githubusercontent.com/BamaRayne/SmartSuite/master/Icons/Speakers.jpg"
        }
        section ("") {    
            href "pConfig", title: "Message Output Settings", description: pConfigComplete(), state: pConfigSettings(),
            image: "https://raw.githubusercontent.com/BamaRayne/SmartSuite/master/Icons/Settings.jpg"
        }
    }
}

// TASK TRACKERS CONFIGURATION
page name: "pTrackers" 
def pTrackers(){
    dynamicPage(name: "pTrackers", title: "", uninstall: false) {
        section ("Tell me about the Task Trackers", hideable: true, hidden: true) {
	        paragraph "Your Task Trackers are now active for ${app.label}. \n" +
                    "\n" +
                  "Task trackers are designed as a quick way for you to keep track of important events or tasks. " +
                  "Do you have trouble remembering when you gave your pet their medicine? Or, when you changed the " +
                  "oil in your vehicles? Or, when the last time you called your Mom was? Well, now you can just tell " +
                  "Alexa that you've done something and she will record the date and time. Then when you want to find " +
                  "out when it was last done, you just ask! \n" +
                  "  \n" +
                  "Configuring a Task Tracker is fairly simple. This example is using a pets daily medicine. " +
                  "My cat is name Calliope and she is diabetic. She recieves an insulin shot twice daily. There are a lot " +
                  "of people in my home, so to ensure we do not over medicate, we use this Task Tracker ~~ \n" +
                    "\n" +
                  "First, I created a profile named Calliope and configured the Task Tracker in that profile " +
                  "I want to say this, 'Alexa, tell Calliope that she got her shot' \n" +
                  "I also want anyone in the home to be able to know right away when she was last medicated. So, using the " +
                  "Task Tracker, anyone can say, 'Alexa, ask Calliope when she was shot', and they are given the date and time \n" +
                  " \n" +
                  "Decide what phrase you want to say to record the Task, and then pull out the key words. In my " +
                  "example the key words are 'Got' 'Her' 'Shot'. \n" +
                  " \n" +  
                  "Put those key words into the Tracker in that order and you're done. Now give it a try! \n"  
        	}
            section ("Task Tracker One", hideable: true, hidden: false) {
            	input "trackerOne2", "text", title: "1st Tracker Key Word #1", required: false, default: "", submitOnChange: true
                input "trackerOne3", "text", title: "1st Tracker Key Word #2", required: false, default: "", submitOnChange: true
                input "trackerOne1", "text", title: "1st Tracker Key Word #3", required: false, default: "", submitOnChange: true
                input "t1notify", "bool", title: "Do you want to set a reminder?", required: false, default: false, submitOnChange: true
                	if (t1notify) {
                    	def title1
                    	if (reminderTitle != null) title1 = "${reminderTitle}"
                        	else {
                            	title1 = "A Reminder has not been created for this Task Tracker" }
                    	paragraph "You can create a reminder that will be scheduled for a future time based on the execution of this " +
                        "Task Tracker. Example: Reminder is configured to run every 12 hours, it will be scheduled for a ONE TIME execution " +
                        "12 hours AFTER this Task Tracker executes. "
                        href "reminderPage1", title: "Create a Reminder for this Task Tracker", description: "${title1}"
                        }
        			}
        	section ("Task Tracker Two", hideable: true, hidden: false) {
            	input "trackerTwo2", "text", title: "2nd Tracker Key Word #1", required: false, default: "", submitOnChange: true
                input "trackerTwo3", "text", title: "2nd Tracker Key Word #2", required: false, default: "", submitOnChange: true
                input "trackerTwo1", "text", title: "2nd Tracker Key Word #3", required: false, default: "", submitOnChange: true
                input "t2notify", "bool", title: "Do you want to set a reminder?", required: false, default: false, submitOnChange: true
                if (t2notify) {
                	def title2
                	if (reminderTitle2 != null) { title2 = "${reminderTitle2}" }
                    	else { 
                        	title2 = "A Reminder has not been created for this Task Tracker" }
                    	paragraph "You can create a reminder that will be scheduled for a future time based on the execution of this " +
                        "Task Tracker. Example: Reminder is configured to run every 12 hours, it will be scheduled for a ONE TIME execution " +
                        "12 hours AFTER this Task Tracker executes. "
                        href "reminderPage2", title: "Create a Reminder for this Task Tracker", description: "${title2}"
                        }
            }
        	section ("Task Tracker Three", hideable: true, hidden: false) {
        		input "trackerThree2", "text", title: "3rd Tracker Key Word #1", required: false, default: false, submitOnChange: true
                input "trackerThree3", "text", title: "3rd Tracker Key Word #2", required: false, default: false, submitOnChange: true
                input "trackerThree1", "text", title: "3rd Tracker Key Word #3", required: false, default: false, submitOnChange: true
                input "t3notify", "bool", title: "Do you want to set a reminder?", required: false, default: false, submitOnChange: true
                if (t3notify) {
                	def title3
                    if (remindertitle3 != null) { title3 = "${reminderTitle3}" }
                    	else {
                        	title3 = "A Reminder has not been created for this Task Tracker" }
                    	paragraph "You can create a reminder that will be scheduled for a future time based on the execution of this " +
                        "Task Tracker. Example: Reminder is configured to run every 12 hours, it will be scheduled for a ONE TIME execution " +
                        "12 hours AFTER this Task Tracker executes. "
        				href "reminderPage3", title: "Create a Reminder for this Task Tracker", description: "${title3}"
                        }
            }
        	section ("Task Tracker Four", hideable: true, hidden: false) {
                input "trackerFour2", "text", title: "4th Tracker Key Word #1", required: false, default: false, submitOnChange: true
                input "trackerFour3", "text", title: "4th Tracker Key Word #2", required: false, default: false, submitOnChange: true
                input "trackerFour1", "text", title: "4th Tracker Key Word #3", required: false, default: false, submitOnChange: true
                input "t4notify", "bool", title: "Do you want to set a reminder?", required: false, default: false, submitOnChange: true
                if (t4notify) {
                	def title4
                    if (remindertitle4 != null) { title4 = "${reminderTitle4}" }
                    	else {
                        	title4 = "A Reminder has not been created for this Task Tracker" }
                    	paragraph "You can create a reminder that will be scheduled for a future time based on the execution of this " +
                        "Task Tracker. Example: Reminder is configured to run every 12 hours, it will be scheduled for a ONE TIME execution " +
                        "12 hours AFTER this Task Tracker executes. "
        				href "t4Reminder", title: "Create a Reminder for this Task Tracker", description: "${title4}"
                        }
            }
        section ("Configure Notifications for $app.label", hideable: true, hidden: true) {
            paragraph "\n" +
                "Send a text message when a tracker is updated. Separate multiple numbers with a comma and " +
                "use this format: +19045554444,+19045554433 " 
            input name: "psms", type: "phone", title: "Send text notification to (optional):", required: false
            input "pPush", "bool", title: "Do you want to send a Push message when Trackers are updated?", required: false, defaultValue: false, submitOnChange: true
			}
    	}
	}           
       
// VIRTUAL PERSON NOTIFICATIONS (SENDS WHEN VP CHECKS IN/OUT)
page name: "pVPNotifyPage"
def pVPNotifyPage() {
    dynamicPage(name: "pVPNotifyPage", title: "Notification Settings") {
        section {
            input "vpPhone", "phone", title: "Text This Number", description: "Phone number", required: false, submitOnChange: true
            paragraph "For multiple SMS recipients, separate phone numbers with a comma"
            input "vpNotification", "bool", title: "Send A Push Notification", description: "Notification", required: false, submitOnChange: true
        }
    }
}   

// VIRTUAL PERSON CONFIG HOME PAGE
page name: "pPerson"
	def pPerson(){
    	dynamicPage(name: "pPerson", title: "", uninstall: false){
			def deviceId = "${app.label}" 
			def d = getChildDevice("${app.label}")
            section("Configure the Virtual Person Device") {
        		if(d==null) {
            	href "pPersonCreate", title: "Create Virtual Person Device"
                }
                if(d) {
                	href "pPersonDelete", title: "Delete Virtual Person Device"
      				input "notifyVPArrive", "bool", title: "Notify when Virtual Person Arrives", required: false, submitOnChange: true
					input "notifyVPDepart", "bool", title: "Notify when Virtual Person Departs", required: false, submitOnChange: true
					if (notifyVPArrive || notifyVPDepart) {
                	href "pVPNotifyPage", title: "Virtual Person Notification Settings", description: VPNotifyComplete(), state: VPNotifySettings()
                	}
                }
            }    
        }
	}

// VIRTUAL PERSON SENSOR DELETE
page name: "pPersonDelete"
def pPersonDelete(){
    dynamicPage(name: "pPersonDelete", title: "", uninstall: false) {
        section ("") {
            paragraph "You have deleted a virtual presence sensor device. You will no longer see this device in your " +
                "SmartThings Environment.  "
        }
        removeChildDevices(getAllChildDevices())
    }
}

// VIRTUAL PERSON SENSOR CREATE
page name: "pPersonCreate"
def pPersonCreate(){
    dynamicPage(name: "pPersonCreate", title: "", uninstall: false) {
        section ("") {
            paragraph "You have created a virtual presence sensor device named ($app.label). !!!DO NOT RENAME THIS DEVICE!!!. " +
              "You will now see this device in your 'Devices' list in the Smartthings IDE and SmartApp."
        }
        virtualPerson()
    }
}

// OUTPUT MESSAGES CONFIGURATION PAGE
page name: "pSend"
def pSend(){
    dynamicPage(name: "pSend", title: "Audio and Text Message Settings", uninstall: false){
        section ("") {
            input "echoDevice", "device.echoSpeaksDevice", title: "Amazon Alexa Devices", multiple: true, required: false
            input "eVolume", "number", title: "Set the volume", description: "0-100 (default value = 30)", required: false, defaultValue: 30
        }
        section (""){
            input "synthDevice", "capability.speechSynthesis", title: "Speech Synthesis Devices", multiple: true, required: false
        }
        section ("") {
            input "sonosDevice", "capability.musicPlayer", title: "Music Player Devices", required: false, multiple: true, submitOnChange: true    
            if (sonosDevice) {
                input "volume", "number", title: "Temporarily change volume", description: "0-100% (default value = 30%)", required: false
            }
        }
        section ("") {
            input "smc", "bool", title: "Send all messages to Smart Message Control", default: false, submitOnChange: true
        }
        section ("" ) {
            input "sendText", "bool", title: "Enable Text Notifications", required: false, submitOnChange: true     
            if (sendText){      
                paragraph "You may enter multiple phone numbers separated by comma to deliver the Alexa message. E.g. +18045551122,+18046663344"
                input name: "sms", title: "Send text notification to (optional):", type: "phone", required: false
            }
        }    
        section ("Push Messages") {
            input "push", "bool", title: "Send Push Notification (optional)", required: false, defaultValue: false
        }
    }                 
}   

// ALEXA RESPONSES PAGE
page name: "pConfig"
def pConfig(){
    dynamicPage(name: "pConfig", title: "Message Output Settings", uninstall: false) {
        section ("Configure Alexa Responses for Voice Messaging") {
            input "pDisableAlexaProfile", "bool", title: "Disable Alexa Feedback Responses (silence Alexa - overrides all other Alexa Options)?", defaultValue: false
            input "pAlexaCustResp", "text", title: "Custom Response from Alexa...", required: false, defaultValue: none
            input "pAlexaRepeat", "bool", title: "Alexa repeats the message to the sender as the response...", defaultValue: false, submitOnChange: true
            if (pAlexaRepeat) {			
                if (pAlexaRepeat && pAlexaCustResp){
                    paragraph 	"NOTE: only one custom Alexa response can"+
                        " be delivered at once. Please only enable Custom Response OR Repeat Message"
                }				
            }
            input "pContCmdsProfile", "bool", title: "Disable Conversation? (Alexa no longer prompts for additional commands, after a message is sent to a remote speaker, except for 'try again' if an error ocurs)", defaultValue: false
        }
        section ("Remote Speaker Settings") {
            input "pRunMsg", "Text", title: "Play this predetermined message when this profile executes...", required: false
            input "pPreMsg", "text", title: "Play this message before your spoken message...", defaultValue: none, required: false 
        	input "pDisableALLProfile", "bool", title: "Disable Audio Output on the Remote Speaker(s)?", required: false
        }
        section ("Text Notifications") {
            input "pRunTextMsg", "Text", title: "Send this predetermined text when this profile executes...", required: false
            input "pPreTextMsg", "text", title: "Append this text before the text message...", defaultValue: none, required: false 
        }             
    }             
}  

// PROFILE ACTIONS ARE EXECUTED EACH TIME THE PROFILE RUNS
page name: "pActions"
def pActions() {
    dynamicPage(name: "pActions", uninstall: false) {
        section ("Trigger these lights and actions when the Profile runs...") {
            href "pDeviceControl", title: "Select Devices...", description: pDevicesComplete() , state: pDevicesSettings()
            input "pMode", "enum", title: "Choose Mode to change to...", options: location.modes.name.sort(), multiple: false, required: false 
            input "shmState", "enum", title: "Set Smart Home Monitor to...", options:["stay":"Armed Stay","away":"Armed Away","off":"Disarmed"], multiple: false, required: false, submitOnChange: true
            if (shmState) {
                input "shmStateKeypads", "capability.lockCodes",  title: "Send status change to these keypads...", multiple: true, required: false, submitOnChange: true
            }
            input "pVirPer", "bool", title: "Toggle the Virtual Person State Automatically when this Profile Runs", default: false, submitOnChange: true, required: false
        		if (pVirPer) {
                	href "pPerson", title: "Configure the Virtual Person for ${app.label}", description: VPCreateComplete(), state: VPCreateSettings()
                    }
        	}
    }
}

// DEVICE CONTROL SELECTION PAGE (TRIGGERED WHEN PROFILE RUNS)
page name: "pDeviceControl"
def pDeviceControl() {
    dynamicPage(name: "pDeviceControl", title: "",install: false, uninstall: false) {
    	section ("Trigger these lights and actions when the Profile runs..."){
        	input "gDoor1", "capability.garageDoorControl", title: "Select Garage Doors...", multiple: true, required: false, submitOnChange: true
            }
        section (""){
            input "sSwitches", "capability.switch", title: "Select Lights and Switches...", multiple: true, required: false, submitOnChange: true
            if (sSwitches) {
                input "sSwitchCmd", "enum", title: "Command To Send",
                    options:["on":"Turn on","off":"Turn off","toggle":"Toggle"], multiple: false, required: false, submitOnChange:true
                input "delaySwitches", "bool", title: "Delay Actions?", required: false, defaultValue: false, submitOnChange:true
                if (delaySwitches) {
                    input "sSecondsOn", "number", title: "Turn on in Seconds?", defaultValue: none, required: false
                    input "sSecondsOff", "number", title: "Turn off in Seconds?", defaultValue: none, required: false
                }
                if (sSwitchCmd) input "sOtherSwitch", "capability.switch", title: "...and these other switches?", multiple: true, required: false, submitOnChange: true                        
                if (sOtherSwitch) input "sOtherSwitchCmd", "enum", title: "Command To Send to these other switches", 
                    options: ["on1":"Turn on","off1":"Turn off","toggle1":"Toggle"], multiple: false, required: false, submitOnChange: true
                if (sOtherSwitchCmd)	input "delayOtherSwitches", "bool", title: "Delay Actions?", required: false, defaultValue: false, submitOnChange:true
                if (delayOtherSwitches) {
                    input "sOtherSecondsOn", "number", title: "Turn on in Seconds?", defaultValue: none, required: false
                    input "sOtherSecondsOff", "number", title: "Turn off in Seconds?", defaultValue: none, required: false
                }
            }
        }
        section (""){
            input "sDimmers", "capability.switchLevel", title: "Select Dimmers...", multiple: true, required: false , submitOnChange:true
            if (sDimmers) { input "sDimmersCmd", "enum", title: "Command To Send",
                options:["on":"Turn on","off":"Turn off", "set":"Set level"], multiple: false, required: false, submitOnChange:true
                          }
            if (sDimmersCmd) {                       
                input "sDimmersLVL", "number", title: "Dimmers Level", description: "Set dimmer level", required: false, submitOnChange: true	
                input "delayDimmers", "bool", title: "Delay Actions?", required: false, defaultValue: false, submitOnChange:true      
                if (delayDimmers) {
                    input "sSecondsDimmers", "number", title: "Turn on in Seconds?", defaultValue: none, required: false
                    input "sSecondsDimmersOff", "number", title: "Turn off in Seconds?", defaultValue: none, required: false                        
                }
                input "sOtherDimmers", "capability.switchLevel", title: "...and these other Dimmers...", multiple: true, required: false , submitOnChange:true
                if (sOtherDimmers) { 
                    input "sOtherDimmersCmd", "enum", title: "Command To Send to these other Dimmers", 
                        options:["on":"Turn on","off":"Turn off","set":"Set level"], multiple: false, required: false, submitOnChange:true
                }
                if (sOtherDimmersCmd) {
                    input "sOtherDimmersLVL", "number", title: "Dimmers Level", description: "Set dimmer level", required: false, submitOnChange: true
                    input "delayOtherDimmers", "bool", title: "Delay Actions?", required: false, defaultValue: false, submitOnChange: true
                    if (delayOtherDimmers) {
                        input "sSecondsOtherDimmers", "number", title: "Turn on in Seconds?", defaultValue: none, required: false
                        input "sSecondsOtherDimmersOff", "number", title: "Turn off in Seconds?", defaultValue: none, required: false                        
                    }
                }
            }
        }
        section (""){
            input "sHues", "capability.colorControl", title: "Select These Colored Lights...", multiple: true, required: false, submitOnChange:true
            if (sHues) {
                input "sHuesCmd", "enum", title: "Command To Send ", 
                    options:["on":"Turn on","off":"Turn off","setColor":"Set Color"], multiple: false, required: false, submitOnChange:true
                if(sHuesCmd == "setColor") {
                    input "sHuesColor", "enum", title: "Hue Color?", required: false, multiple:false, options: fillColorSettings().name
                }
                if(sHuesCmd == "setColor" || sHuesCmd == "on") {
                    input "sHuesLevel", "enum", title: "Light Level?", required: false, options: [[10:"10%"],[20:"20%"],[30:"30%"],[40:"40%"],[50:"50%"],[60:"60%"],[70:"70%"],[80:"80%"],[90:"90%"],[100:"100%"]], submitOnChange:true                        
                }
            }
            if (sHuesLevel)	input "sHuesOther", "capability.colorControl", title: "...and these other Colored Lights?", multiple: true, required: false, submitOnChange:true
            if (sHuesOther) {
                input "sHuesOtherCmd", "enum", title: "Command To Send to these other Colored Lights", options:["on":"Turn on","off":"Turn off","setColor":"Set Color"], multiple: false, required: false, submitOnChange:true
                if(sHuesOtherCmd == "setColor") {
                    input "sHuesOtherColor", "enum", title: "Which Color?", required: false, multiple:false, options: fillColorSettings().name
                }
                if(sHuesOtherCmd == "on" || sHuesOtherCmd == "setColor") {
                    input "sHuesOtherLevel", "enum", title: "Light Level?", required: false, options: [[10:"10%"],[20:"20%"],[30:"30%"],[40:"40%"],[50:"50%"],[60:"60%"],[70:"70%"],[80:"80%"],[90:"90%"],[100:"100%"]]                       
                }
            }
        }
        section ("") {
            input "sFlash", "capability.switch", title: "Flash Switch(es)", multiple: true, required: false, submitOnChange:true
            if (sFlash) {
                input "numFlashes", "number", title: "This number of times (default 3)", required: false, submitOnChange:true
                input "onFor", "number", title: "On for (default 1 second)", required: false, submitOnChange:true			
                input "offFor", "number", title: "Off for (default 1 second)", required: false, submitOnChange:true
            }
        }
    }
} 

// DEVICE CONTROLS PAGE
page name: "cDevices"
def cDevices() {
    dynamicPage(name: "cDevices", title: "", install: false, uninstall: false) {
        section ("Run the actions for this webCoRE Piston") {
                input "myPiston", "enum", title: "Choose Piston...", options:  parent.webCoRE_list('name'), multiple: false, required: false, submitOnChange: true,
                image: "https://cdn.rawgit.com/ady624/${parent.webCoRE_handle()}/master/resources/icons/app-CoRE.png"
        			if (myPiston) { 
                    paragraph "Execute this piston by saying, 'Alexa, run piston $myPiston in the $app.label'"
                    }
            	}
        section ("Weather Alerts") {
            input "activateAlerts", "bool", title: "Activate automatic weather alert updates. Warning: Activate in ONLY ONE PROFILE", required: false, defaultValue: false, submitOnChange: true
       //     input "variables", "enum", title: "Select a variable", required: false, options: [[tor:"Tornado"]], submitOnChange: true 
            if (activateAlerts) {
                    input "smcAlert", "bool", title: "Send all messages to Smart Message Control", default: false, submitOnChange: true
                    if (smcAlert == false) {
                    input "echoDeviceAlert", "device.echoSpeaksDevice", title: "Amazon Alexa Devices", multiple: true, required: false
                    	if (echoDeviceAlert) {
                    		input "eVolumeAlert", "number", title: "Set the volume", description: "0-100 (default value = 30)", required: false, defaultValue: 30
                            }
                    input "synthDeviceAlert", "capability.speechSynthesis", title: "Speech Synthesis Devices", multiple: true, required: false
                    input "sonosDeviceAlert", "capability.musicPlayer", title: "Music Player Devices", required: false, multiple: true, submitOnChange: true    
                    	if (sonosDeviceAlert) {
                        	input "volumeAlert", "number", title: "Temporarily change volume", description: "0-100% (default value = 30%)", required: false
                    	}
                    }
                	input "alertTxt", "bool", title: "Send a text when a weather alert is received", required: false, defaultValue: false, submitOnChange: true
            		if (alertTxt) {
                	input name: "smsAlert", title: "Send Text to this number", type: "phone", required: true
                	}
             		href "alertRestrict", title: "Weather Alert Restrictions"//, description: VPNotifyComplete(), state: VPNotifySettings()	
            }
        }        
        section ("Controllable Devices") {}
        section ("Location and System Settings") {
        	input "allowAlarm", "bool", title: "Can this room control the Smart Home Monitor Alarm system?", required: false, default: false, submitOnChange: true
            input "mMode", "enum", title: "Choose Modes to be used by this Room...", options: location.modes.name.sort(), multiple: true, required: false 
            input "gDisable", "capability.switch", title: "Automation Disable Switches (disable = off, enable = on)", multiple: true, required: false, submitOnChange: true
            if (gDisable) { 
                input "gDisTime", "number", title: "Automatically restore Automations after this number of minutes", defaultValue: 60, required: false
            }
            input "gNotDisable", "capability.switch", title: "Notification Disable Switches (disable = off, enable = on)", multiple: true, required: false, submitOnChange: true
            if (gNotDisable) {
                input "gNotDisTime", "number", title: "Automaticaly restore Notifications after this number of minutes", defaultValue: 60, required: false
            }
        }
        section ("Lights, Colored Bulbs, and Switches") {
        	input "gSwitches", "capability.switch", title: "Lights and Switches...", multiple: true, required: false
            }
        section ("Window Coverings and Doors") {
        	input "gGarage", "capability.garageDoorControl", title: "Garage Door(s)...", multiple:true, required: false
            input "gShades",  "capability.windowShade", title: "Window Covering Devices...", multiple: true, required: false 
            }
        section ("Environmental Groups"){ 
            input "gVents", "capability.switchLevel", title: "Smart Vent(s)...", multiple: true, required: false
            input "gFans", "capability.switch", title: "Fans and Ceiling Fans...", multiple: true, required: false
            input "gFire", "capability.switch", title: "Fireplaces...", multiple: true, required: false
        	input "Thermostat1", "capability.thermostat", title: "First ThermoStat", required: false, default: false, submitOnChange: true 
        	input "Thermostat2", "capability.thermostat", title: "Second ThermoStat", required: false, default: false, submitOnChange: true 
            }
        section ("Locks") {
        	input "gLock", "capability.lock", title: "Smart Locks...", multiple: true, required: false
            }
        section ("Media"){
        	input "sTV", "capability.switch", title: "Televisions...", multiple: true, required: false
            input "sMedia", "capability.mediaController", title: "Media Controller", multiple: false, required: false
            input "sSpeaker", "capability.musicPlayer", title: "Media Player Devices (Select your Amazon Echo's Here)", required: false, multiple: true
//            input "sSynth", "capability.speechSynthesis", title: "Speech Synthesis Capable Devices", multiple: ttrue, required: false
        }             
        section ("Custom Groups") {
            input "gCustom1N", "text", label: "Name this Group...", multiple: false, required: false, defaultLabel: "Custom Group 1"
            input "gCustom1", "capability.switch", title: "Select Switches for $gCustom1N...", multiple: true, required: false
            	if (gCustom1) {         
            input "gCustom2N", "text", label: "Name this Group...", multiple: false, required: false, defaultLabel: "Custom Group 2"
            input "gCustom2", "capability.switch", title: "Select Switches for $gCustom2N...", multiple: true, required: false
            }
            	if (gCustom2) {
            input "gCustom3N", "text", label: "Name this Group...", multiple: false, required: false, defaultLabel: "Custom Group 3"  
			input "gCustom3", "capability.switch", title: "Select Switches for $gCustom3N...", multiple: true, required: false
            }
            	if (gCustom3) {
            input "gCustom4N", "text", label: "Name this Group...", multiple: false, required: false, defaultLabel: "Custom Group 4"    
			input "gCustom4", "capability.switch", title: "Select Switches for $gCustom4N...", multiple: true, required: false
            }
            	if (gCustom4) {
            input "gCustom5N", "text", label: "Name this Group...", multiple: false, required: false, defaultLabel: "Custom Group 5"    
			input "gCustom5", "capability.switch", title: "Select Switches for $gCustom5N...", multiple: true, required: false
        	}
        }
        section ("Non-Controllable Devices (Sensors)") {}
		section("Netatmo Weather Station") {
        	input "NetatmoTrue", "bool", title: "Do you have any of the Netatmo Weather Station Modules?", required: false, default: false, submitOnChange: true
        		if (NetatmoTrue) {
				input "fWind", "capability.sensor", title: "Wind Speed", multiple: false, required: false, submitOnChange: true
            	input "fRain", "capability.sensor", title: "Rain Accumulation", multiple: false, required: false, submitOnChange: true
            	input "fOutDoor", "capability.sensor", title: "Outdoor Module", multiple: false, required: false, submitOnChange: true
            	input "fBase", "capability.sensor", title: "Base Station", multiple: false, required: false, submitOnChange: true
            	input "fIndoor", "capability.sensor", title: "Indoor Modules", multiple: true, required: false, submitOnChange: true
			}
        }        
        section("Doors and Windows") {
            input "fDoors", "capability.contactSensor", title: "Contacts only on Doors...", multiple: true, required: false
        	input "fWindows", "capability.contactSensor", title: "Contacts only on Windows...", multiple: true, required: false
        	}
        section("Environmental Devices") {
            input "fTemp", "capability.temperatureMeasurement", title: "Devices that Report Temperature...", multiple: true, required: false
			input "fHum", "capability.relativeHumidityMeasurement", title: "Devices that Report Humidity...", multiple: true, required: false
            input "fWeather", "capability.sensor", title: "Weather Device for local environment feedback...", multiple: false, required: false
        }
        section("Motion and Presence") {
            input "fPresence", "capability.presenceSensor", title: "Presence Sensors...", required: false, multiple: true
        	input "fMotion", "capability.motionSensor", title: "Motion Sensors...", required: false, multiple: true
        }
        section("Power Meters") {
        	input "fPower", "capability.powerMeter", title: "Aeon Power Meters...", multiple: true, required: false
            input "ofPower", "capability.powerMeter", title: "Iris Smart Plugs...", multiple: true, required: false
            	if (fPower || ofPower) {
                	input "fCosts", "string", title: "What is your cost per kilowatt hour?", required: false, defaultValue: 0.000, submitOnChange: true
        	}
        }
    }
}

// RESTRICTIONS HOME PAGE
page name: "pRestrict"
def pRestrict(){
    dynamicPage(name: "pRestrict", title: "Profile Restrictions", uninstall: false) {
        section ("") {
            input "modes", "mode", title: "Audio only when mode is", multiple: true, required: false
        }        
        section (""){	
            input "days", title: "Audio only on these days of the week", multiple: true, required: false,
                "enum", options: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
        }
        section (""){
            href "certainTime", title: "Audio only during a certain time", description: pTimeComplete(), state: pTimeSettings()
        }   
    }
}

// RESTRICTION PAGE - TIME SELECTIONS
page name: "certainTime"
def certainTime() {
    dynamicPage(name:"certainTime",title: "Only during a certain time", uninstall: false) {
        section("Beginning at....") {
            input "startingX", "enum", title: "Starting at...", options: ["A specific time", "Sunrise", "Sunset"], required: false , submitOnChange: true
            if(startingX in [null, "A specific time"]) input "starting", "time", title: "Start time", required: false, submitOnChange: true
            else {
                if(startingX == "Sunrise") input "startSunriseOffset", "number", range: "*..*", title: "Offset in minutes (+/-)", required: false, submitOnChange: true
                else if(startingX == "Sunset") input "startSunsetOffset", "number", range: "*..*", title: "Offset in minutes (+/-)", required: false, submitOnChange: true
                    }
        }
        section("Ending at....") {
            input "endingX", "enum", title: "Ending at...", options: ["A specific time", "Sunrise", "Sunset"], required: false, submitOnChange: true
            if(endingX in [null, "A specific time"]) input "ending", "time", title: "End time", required: false, submitOnChange: true
            else {
                if(endingX == "Sunrise") input "endSunriseOffset", "number", range: "*..*", title: "Offset in minutes (+/-)", required: false, submitOnChange: true
                else if(endingX == "Sunset") input "endSunsetOffset", "number", range: "*..*", title: "Offset in minutes (+/-)", required: false, submitOnChange: true
                    }
        }
    }
}

/************************************************************************************************************
		Weather Alert Restrictions Page
************************************************************************************************************/    
page name: "alertRestrict"
def alertRestrict(){
    dynamicPage(name: "alertRestrict", title: "", uninstall: false) {
        section ("Mode Restrictions") {
            input "alertMode", "mode", title: "Only when mode is", multiple: true, required: false
        }        
        section ("Days - Audio only on these days"){	
            input "alertDays", title: "Only on certain days of the week", multiple: true, required: false, submitOnChange: true,
                "enum", options: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
        }
        section ("Time - Audio only during these times"){
            href "alertTime", title: "Only during a certain time", description: pTimeComplete() , state: pTimeSettings()
        }
        section ("Switches") {
            input "alertSwitch", "capability.switch", title: "Only when this switch...", multiple: true, required: false, submitOnChange: true
            if (alertSwitch) {
                input "alertSwitchCmd", "enum", title: "is in the $alertSwitchCmd position...",
                    options:["on":"On","off":"Off"], multiple: false, required: false, submitOnChange:true
    		}
            if (alertSwitch?.size() > 1) {
                input "alertSwitchAll", "bool", title: "Activate this toggle if you want ALL of the switches to be $alertSwitchCmd as a condition.", required: false, defaultValue: false, submitOnChange: true
            }
        }
    }
}
page name: "alertTime"
def alertTime() {
    dynamicPage(name:"alertTime",title: "Only during a certain time", uninstall: false) {
        section("Beginning at....") {
            input "startingXA", "enum", title: "Starting at...", options: ["A specific time", "Sunrise", "Sunset"], required: false , submitOnChange: true
            if(startingXA in [null, "A specific time"]) input "startingA", "time", title: "Start time", required: false, submitOnChange: true
            else {
                if(startingXA == "Sunrise") input "startSunriseOffsetA", "number", range: "*..*", title: "Offset in minutes (+/-)", required: false, submitOnChange: true
                else if(startingXA == "Sunset") input "startSunsetOffsetA", "number", range: "*..*", title: "Offset in minutes (+/-)", required: false, submitOnChange: true
                    }
        }
        section("Ending at....") {
            input "endingXA", "enum", title: "Ending at...", options: ["A specific time", "Sunrise", "Sunset"], required: false, submitOnChange: true
            if(endingXA in [null, "A specific time"]) input "endingA", "time", title: "End time", required: false, submitOnChange: true
            else {
                if(endingXA == "Sunrise") input "endSunriseOffsetA", "number", range: "*..*", title: "Offset in minutes (+/-)", required: false, submitOnChange: true
                else if(endingXA == "Sunset") input "endSunsetOffsetA", "number", range: "*..*", title: "Offset in minutes (+/-)", required: false, submitOnChange: true
                    }
        }
    }
}

/************************************************************************************************************
**** HANDLERS FOLLOW
************************************************************************************************************/

// VIRTUAL PERSON CREATE HANDLER
def virtualPerson() {
    log.trace "Creating Voice Companion Virtual Person Device"
    def deviceId = "${app.label}" 
    def d = getChildDevice("${app.label}")
    if(!d) {
        d = addChildDevice("Assistant", "Voice Companion Simulated Presence Sensor", deviceId, null, [label:"${app.label}"])
        log.trace "Voice Companion Virtual Person Device - Created ${app.label} "
    }
    else {
        log.trace "NOTICE!!! Found that the EVPD ${d.displayName} already exists. Only one device per profile permitted"
    }
}  

// VIRTUAL PERSON DELETE HANDLER
private removeChildDevices(delete) {
    log.debug "The Virtual Person Device '${app.label}' has been deleted from your SmartThings environment"
    delete.each {
        deleteChildDevice(it.deviceNetworkId)
    }
}

// VIRTUAL PERSON CHECK IN/OUT TOGGLE HANDLER
private pVirToggle() {
	def vp = getChildDevice("${app.label}")
    if(vp) {
    if (vp?.currentValue('presence')?.contains('not')) {
            log.info "${app.label} has arrived"
            vp.arrived()
            }
        else if (vp?.currentValue('presence')?.contains('present')) {
            log.info "${app.label} has departed"
            vp.departed()
            }
    	}
	}

/************************************************************************************************************
	SECURITY CONTROL HANDLER
************************************************************************************************************/ 
def securityHandler(tts) {
    def currentSHM = location.currentState("alarmSystemStatus")?.value
    if (allowAlarm==false) { 
        tts = "I'm sorry, but this room does not have permission to change the Alarm System. Please speak to the system administrator"
    }
    if (allowAlarm==true) {
        if (tts.contains("turn on the alarm")){
            if (allowAlarm==true) {
                sendLocationEvent(name: "alarmSystemStatus", value: "stay")
                tts = "I changed the Smart Home Monitor to armed stay"
                log.info "securityHandler On says: $tts"
                return tts
            }
        }
        if (tts.contains("turn off the alarm")){ 
            sendLocationEvent(name: "alarmSystemStatus", value: "off")
            tts = "I have disarmed the Smart Home Monitor Alarm system"
            log.info "securityHandler Off says: $tts"
            return tts
        }
    }
    return tts
}    

/************************************************************************************************************
Base Process
************************************************************************************************************/    
def installed() {
    log.debug "Installed with settings: ${settings}, current app version: ${release()}"
    state.ProfileRelease ="Profile: "  + release()
    initialize()
}

def updated() {
    log.debug "Updated with settings: ${settings}"
	
    state.ProfileRelease = "Profile: " + release()
    unsubscribe()
    initialize()
    if(!atomicState?.isInstalled) { atomicState?.isInstalled = true }
}
def initialize() {
	if (activateAlerts) {
    	runEvery15Minutes(mGetWeatherAlerts)
        }
    if (activateAlerts == false) {
    	unschedule(mGetWeatherAlerts)
        }
	def roomName = "$app.label"
	parent.state.childRevision = revision(text)
	parent.webCoRE_init()
    state.alertCount
    state.newAlert
    state.tts
    state.sc
    state.lastMessage
    state.lastTime
    state.lastAction = null
    state.lastActivity
    //Sound Cancellation    
    state.pMuteAlexa = settings.pDisableAlexaProfile ?: false
    state.pMuteAll = settings.pDisableALLProfile ?: false
    // Turn OFF the Color Loop
//    unschedule("startLoop")
//    unschedule("continueLoop")
    //SHM status change and keypad initialize
    state.responseTxt = null
    state.lambdaReleaseTxt = "Not Set"
    state.lambdaReleaseDt = "Not Set" 
    state.lambdatextVersion = "Not Set"
    //Alexa Responses
    
    state.pTryAgain = false
    state.pContCmds = settings.pContCmdsProfile == false ? true : settings.pContCmdsProfile == true ? false : false
    state.pMuteAlexa = settings.pEnableMuteAlexa
    state.pShort = settings.pUseShort
    state.pContCmdsR = "init"       
    //OTHER 
    state.sched
    state.sched2
    state.sched3
    state.sched4
    state.date
    if (fMinutes1) { state.fSched1 = "1" }
    	else { state.fSched1 = "0" }
    	log.info "fSched1 = $state.fSched1"
    def String deviceType = (String) null
    def String outputTxt = (String) null
    def String result = (String) null
    def String deviceM = (String) null
    def currState
    def stateDate
    def stateTime
    def data = [:]
//    if (fDevice != null) {
//        fDevice = fDevice.replaceAll("[^a-zA-Z0-9 ]", "") }
    def fProcess = true
    state.pTryAgain = false
    if (taskTrackers) {
        log.info "Initializing Task Tracker variable for '${app.label}'"
        if (state.trackerOne == null) {state.trackerOne = "I'm sorry, I have not been told when the ${trackerOne1} was ${trackerOne2}" }
        if (state.trackerTwo == null) {state.trackerTwo = "I'm sorry, I have not been told when the ${trackerTwo1} was ${trackerTwo2}" }
        if (state.trackerThree == null) {state.trackerThree = "I'm sorry, I have not been told when the ${trackerThree1} was ${trackerThree2}" }
        if (state.trackerFour == null) {state.trackerFour = "I'm sorry, I have not been told when the ${trackerFour1} was ${trackerFour1}" }
    }
    //LOGIC BLOCKS
    	subscribe(location, "RemindRevent", remindRHandler)
        subscribe(location, "remindR", remindRProfiles)
        state.thePaused = null
        state.theRunning = null
        state.esEvent = [:]
        runningAppsFalseUpdate()
        runningAppsTrueUpdate()
        sendLocationEvent(name: "LogicRulz", value: "refresh", data: [blocks: getProfileList()] , isStateChange: true, descriptionText: "LogicRulz list refresh")		
        state.profiles = state.profiles ? state.profiles : []
        state.zones = state.zones ? state.zones : []
}

def uninstalled() {
	revokeAccessToken()
    LogAction("${app?.getLabel()} has been Uninstalled...", "warn", true)
}

private stripBrackets(str) {
  	str = str.replace("[", "")
	return str.replace("]", "")
}

/******************************************************************************************************
PARENT STATUS CHECKS
******************************************************************************************************/
def checkState() {
return state.pMuteAlexa
}
def checkRelease() {
return revision(text)
//return state.ProfileRelease
}


/******************************************************************************************************
SPEECH AND TEXT PROCESSING INTERNAL - FEEDBACK
******************************************************************************************************/
def profileFeedbackEvaluate(params) {
    log.info "profileFeedbackEvaluate has been activated with params: $params"
    def deviceId = parent.state.deviceId
    def tts = params.ptts.toLowerCase()
    def intent = params.pintentName        
    def childName = app.label       
    def data = [:]
    //Output Variables
    def pTryAgain = false
    def pPIN = false
    def pShort = state.pShort
    def String pContCmdsR = (String) "tts"
    def String outputTxt = (String) null 
    def String scheduler = (String) null     
    def String ttsR = (String) null
    def String colorMatch = (String) null
if (roomDevice != null) {
	log.debug "state.deviceId = $deviceId"
	if ("$deviceId" == "$roomDevice") {
    log.debug "This room can only be activated by the device: $roomDevice"
    }
}

    // SKIPS PARSING AND SEND ENTIRE INCOMING TTS AS AN OUTGOING MESSAGE 
    if (tts.startsWith("hey ")) {  
        def ttsText = tts.toLowerCase()
        ttsHandler(tts)
        outputTxt = "Ok, your message has been sent to $app.label"
        return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
    }			
    if (tts != null) {
        tts = tts.replaceAll("[^a-zA-Z0-9-' ]", "") }

    if (command == "undefined") {
        outputTxt = "Sorry, I didn't get that, "
        state.pTryAgain = false
        state.pContCmdsR = "clear"
        state.lastAction = null
        return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
    }    
    if (intent == childName){

        if (tts.contains("current revision") || tts.contains("current version")) {
            def roomsRev = revision(text)
            def parentRev = parent.release()
			outputTxt = "The current Echosistant Parent app Revision is, $parentRev. The Rooms Revision is, $roomsRev" //, and the ShortCuts Revision is $shortRev"
            if (parent.debug) log.debug "Revision Requested: $outputTxt"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
        }

		if ((tts.contains("alert") || tts.contains("alerts")) && tts.contains("weather")) {
    		outputTxt = verbalWeatherAlerts()
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
		}

        // ALEXA DEVICES - LAST THING SPOKEN
        if (tts.contains("last thing said")) {
            def result = "The last thing spoken on the " +  "${sSpeaker}" + " was, " + sSpeaker?.currentState("lastSpeakCmd")?.stringValue
            outputTxt = stripBrackets(result ? " $result " : "")
            if (parent.debug) log.debug "Alexa Device: Last speak cmd was --> $result"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
        }
        // ALEXA DEVICE - WAKE WORD
        if (tts.contains("wake word")) {
            def result = "The wake word for the " +  "${sSpeaker}" + " is, " + sSpeaker.currentState("alexaWakeWord")?.stringValue
            outputTxt = stripBrackets(result ? " $result " : "")
            if (parent.debug) log.debug "Alexa Device: Wake Word is --> $result"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
        }
        // ALEXA DEVICE - VOLUME
        if (tts.contains("what is the volume")) {
            def result = "The volume in the $app.label is set to " + sSpeaker.currentState("level")?.stringValue + " percent"
            outputTxt = stripBrackets(result ? " $result " : "")
            if (parent.debug) log.debug "$app.label: Volume Level is --> $result"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
        }
        // ALEXA DEVICE - WHATS PLAYING
        if (tts.contains("what is playing") || tts.contains("what was the last song") || tts.contains("whats playing")) {
            outputTxt = "The song " + sSpeaker.currentState("currentStation")?.stringValue + " by " + sSpeaker.currentState("currentAlbum")?.stringValue + " was the last thing played in the $app.label"
            if (parent.debug) log.debug "Alexa Device: What's playing: $outputTxt"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
        }

    //  SMART HOME MONITOR STATUS
        if (tts.contains("check the alarm") || tts.contains("is the alarm") || tts.contains("security system") || tts.contains("smart home monitor")) {
            def currentSHM = location.currentState("alarmSystemStatus")?.value
            def shmStatus = currentSHM == "stay" ? "armed home" : currentSHM == "away" ? "armed away" : currentSHM == "off" ? "set to disarmed" : null
            if (tts.contains(" on") || tts.contains(" armed")) {
                outputTxt = "Yes, the alarm is currently set to $shmStatus"
                if (currentSHM == ("off")) {
                    outputTxt = "No, the alarm is currently $shmStatus"
                }
            }
            if (tts.contains(" off") || tts.contains("disarmed")) {
                outputTxt = "No, the alarm is currently set to $shmStatus"
                if (currentSHM == ("off")) {
                    outputTxt = "Yes, the alarm is currently $shmStatus"
                }
            }
            if (tts.contains("check the alarm")) {
            	outputTxt = "The alarm is currently $shmStatus"
                }    
            if (parent.debug) log.debug "$outputTxt"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN] 
        }

	//  MODE STATUS FEEDBACK
        if (tts.contains("mode")) {
            outputTxt = "The Current Mode is " + location.currentMode
            if (parent.debug) log.debug "$outputTxt"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
        }

	//  FEEDBACK HANDLER - (FEEDBACK PARSING ENGINE) 
		def fDevice = tts.contains("notifications") ? gNotDisable : tts.contains("automations") ? gDisable : tts.contains("eon") ? fPower : tts.contains("iris") ? fPower : 
        tts.contains("vent") ? gVents : tts.contains("light") ? gSwitches :  tts.contains("garage") ? gGarage : tts.contains("doors") ? fDoors : tts.contains("door") ? fDoors : 
        tts.contains("window") ? fWindows : tts.contains("windows") ? fWindows : tts.contains("fireplace") ? gFire : tts.contains("arrive") ? fPresence : tts.contains("leave") ? fPresence :
        tts.contains("fan") ? gFans : tts.contains("lights") ? gSwitches : tts.contains("TV") ? fSwitches : tts.contains("motion") ? fMotion : tts.contains("lock") ? gLocks : 
        tts.contains("shade") ? gShades : tts.contains("curtains") ? gShades : tts.contains("blinds") ? gShades : tts.startsWith("who") ? fPresence :
        tts.contains("television") ? sTV : tts.contains("lamp") ? gSwitches : tts.contains("automations") ? gSwitches : tts.contains("spotlight") ? gSwitches : 
        tts.contains("spot") ? gSwitches : tts.contains("outlet") ? gSwitches : tts.contains("strip") ? gSwitches : tts.contains("tv") ? sTV : null

        def fValue = tts.contains("notifications") ? "switch" : tts.contains("automations") ? "switch" : tts.contains("vent") ? "switch" : tts.contains("light") ? "switch" : tts.contains("garage") ? "contact" :
        tts.contains("door") ? "contact" : tts.contains("windows") ? "contact" : tts.contains("fan") ? "switch" : tts.contains("lights") ? "switch" : tts.contains("eon") ? "switch" : 
        tts.contains("doors") ? "contact" : tts.contains("iris") ? "switch" : tts.contains("television") ? "switch" : tts.contains("lock") ? "lock" : tts.contains("shade") ? "windowShade" :   
        tts.contains("who") ? "presence" : tts.contains("curtains") ? "windowShade" : tts.contains("fireplace") ? "switch" : tts.contains("tv") ? "switch" : tts.contains("tv") ? "switch" :
        tts.contains("lamp") ? "switch" : tts.contains("spotlight") ? "switch" : tts.contains("spot") ? "switch" : tts.contains("outlet") ? "switch" : tts.contains("strip") ? "switch" :  
        tts.contains("blind") ? "windowShade" : tts.contains("window") ? "contact" : tts.contains("motion") ? "motion" : tts.contains("arrive") ? "presence" : tts.contains("leave") ? "presence" : null

        def fName = tts.contains("notifications") ? "notification" : tts.contains("automations") ? "automation" : tts.contains("motion") ? "motion sensors" : tts.contains("tv") ? "TV" :
        tts.contains("vent") ? "vent" : tts.contains("lock") ? "lock" : tts.contains("garage door") ? "garage door" : tts.contains("doors") ? "doors" : tts.contains("door") ? "door" : tts.contains("windows") ? "windows" : tts.contains("fan") ? "fan" : 
        tts.contains("lights") ? "lights" : tts.contains("light") ? "light" : tts.contains("shade") ? "shade" : tts.contains("blind") ? "blind" : tts.contains("curtains") ? "curtain" : tts.contains("window") ? "window" :
        tts.contains("fireplace") ? "fireplace" : tts.contains("television") ? "TV" : tts.contains("lamp") ? "lamp" : tts.contains("spotlight") ? "spotlight" : tts.contains("spot") ? "spot" : 
        tts.contains("outlet") ? "outlet" : tts.contains("strip") ? "strip" : tts.contains("who") ? "presence" : null

        def fCommand = tts=="who is" ? "present" : tts=="who is not" ? "not present" : tts=="who is at home" ? "present" : tts=="who is home" ? "present" : tts=="who is not home" ? "not present" : tts=="who is not at home" ? "not present" : tts.contains("open") ? "open" : tts.contains("closed") ? "closed" : tts.contains(" on") ? "on" : tts.contains("off") ? "off" : null

        if (tts.contains("check") && tts.contains("light")) { fCommand = "on" }
        if (tts.contains("motion")) { fCommand = "active" }
        if (tts.contains("check")) {
            if (tts.contains("lock") || tts.contains("door") || tts.contains("window") || tts.contains("vent") || tts.contains("shades") || tts.contains("blind") || tts.contains("curtain")) {
                fCommand = "open" }}
        if (tts.startsWith("tell me")) {
            if (tts.contains("doors") || tts.contains("windows")) {
                fCommand = "open"
            }
            if (tts.contains("lights") || tts.contains("vents")) {
                fCommand = "on"
            }
        }    
                
        log.info "fDevice: $fDevice, fValue: $fValue, fName: $fName, fCommand: $fCommand"
        if (tts.contains("when was ") || tts.contains("when did ")) {
            log.warn "the devices are: $fDevice"

            if (fValue == "presence") {
                fDevice?.each { d ->
                    def device = d.name.toLowerCase()
                    if (tts.contains("${device}")) {
                        log.warn "The device is: $device and fValue is: $fValue"
                        def currState = d.latestValue("${fValue}")
                        log.info "currState is: $currState"
                        def stateTime = d.currentState("${fValue}").date.time
                        def timeText = getTimeVariable(stateTime, deviceType)
                        if ("${currState}" == "present") { 
                            def presStatus = "arrived" 
                            outputTxt = "$d last $presStatus, $timeText.currDate at $timeText.currTime"
                        }
                        if ("${currState}" != "present") { 
                            def presStatus = "departed" 
                            outputTxt = "$d last $presStatus, $timeText.currDate at $timeText.currTime"
                        }
                    }
                }
            }
            if (fValue != "presence") {
                fDevice?.each { d ->
                    def device = d.label.toLowerCase()
                    if (tts.contains("${device}")) {
                        def currState = d.latestValue("${fValue}")
                        def stateTime = d.currentState("${fValue}").date.time
                        def timeText = getTimeVariable(stateTime, deviceType)
                        log.warn "The $d status last changed to $currState, $timeText.currDate at $timeText.currTime"
                        outputTxt = "The $d status last changed to $currState, $timeText.currDate at $timeText.currTime"
                    }
                }
            }
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
        }

        //  MISC DEVICES FEEDBACK - BUILDS DEVICE LISTS        
        if (tts.contains("tell me about the") || tts.contains("how") || tts.contains("television") || tts.contains("who") || tts.contains("window") || tts.contains("vent") || tts.contains("lock") || tts.contains("blind") || tts.contains("curtain") || 
        	tts.contains("shade") || tts.contains("garage") || tts.contains("door") || tts.contains("lights")  || tts.contains("light") || tts.contains("fan") || tts.contains("automations") || tts.contains("notifications") || 
            tts.contains("fireplace") || tts.contains("outlet") || tts.contains("strip") || tts.contains("spot") || tts.contains("spotlight") || tts.contains("lamp") || tts.contains("tv") || tts.contains("windows") || tts.contains("what")) {
            if (tts.startsWith("tell me about") || tts.contains(" on") || tts.endsWith("off") || tts.contains("open") || tts.contains("closed") || tts.startsWith("who is") || tts.endsWith("home") || tts.startsWith("check") || tts.contains("eon") ||tts.contains("switches")) {
                def devList = [] 
                if (fDevice == null) {
                    outputTxt = "I'm sorry, it seems that you have not selected any devices for this query, please configure your feedback devices in the EchoSistant smartapp."
                    if (parent.debug) log.debug "Feedback handler: $outputTxt"
                    return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
                }
                fDevice.each { deviceName ->
                    if (deviceName.latestValue("${fValue}")=="${fCommand}") {
                        String device  = (String) deviceName
                        devList += device
                        }
          
             // PRESENCE RETURNS //        
                if (tts.startsWith("who") && (tts.endsWith("home") || tts.endsWith("at home") || tts.endsWith("is") || tts.endsWith("not"))) {
                    if (devList.size() >0) {
                        if (devList.size() == 1) { outputTxt = "The only person $fCommand is $devList" }
                        if (devList.size() >1) { outputTxt = "The following people are $fCommand, $devList" }}
                    else if (fCommand == "not present") { outputTxt = "Everyone is currently at home" }
                    if (parent.debug) log.debug "Presence requested: $outputTxt"
                    return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
                }
            // MISC DEVICES RETURNS A YES OR NO //
                if (tts.startsWith("tell me") || tts.startsWith("are") || tts.startsWith("how many") || tts.startsWith("check")) {
                    if (devList.size() > 0) {
                    	if (devList.size() == 1) {
                        	outputTxt = "There is one $fName " + fCommand + " in the ${app.label} " 
                            }
                        	else { 
                        		outputTxt = "There are " + devList.size() + " " + fName + " " + fCommand + " in the ${app.label} " 
                        	}
                    	}    
                    	else {outputTxt = "There are no $fName " + fCommand + " in the ${app.label} " 
                        }
                if (parent.debug) log.debug "Number of devices requested: $outputTxt"    
                    return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
                }
            // RETURNS A LIST OF DEVICES //        
                if (tts.startsWith("what $fName ") || tts.startsWith("which")) {  //(tts.contains (" $fName are $fCommand") || tts.contains (" $fName is $fCommand")) {
                    if (devList.size() >= 1) { 
                        if (devList.size() == 1) {
                        	outputTxt = "The" + devList + " is the only " + fName + " " + fCommand +  " in the ${app.label} "
                            }
                        	else 
                            	{
                                outputTxt = "The following $fName are $fCommand in the $app.label $devList" 
                                }
                            }
                    		else {
                            	outputTxt = "There aren't any $fName $fCommand in the $app.label" 
                                }
                    if (parent.debug) log.debug "The List of devices requested: $outputTxt"
                return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
                }
            
            // RETURNS YES OR NO FOR A DEVICES STATUS
            if (tts.startsWith("is the")) {
            	fDevice.each { s ->
                def lMatch = s.label.toLowerCase()
                if (parent.debug) log.debug "the matched device, lMatch is: $s"
                if(tts.contains("television")) {
                    lMatch = "television"
                	}
                if (tts.contains("$lMatch")) {
                    def fLightsStatus
                    if (tts.contains(" door") || tts.contains("window")) {
                    	fLightsStatus = s?.latestValue("contact")
                        log.warn "fLightsStatus is: $fLightsStatus"
                        } else {
                    		fLightsStatus = s?.latestValue("switch")
                            }
                    if (tts.contains("on") || tts.contains("open")) {
                        if (fLightsStatus == "on" || fLightsStatus == "open") {
                            outputTxt = "Yes, the $lMatch is $fLightsStatus"
                        }
                        if (fLightsStatus == "off" || fLightsStatus == "closed") {
                            outputTxt = "No, the $lMatch is currently $fLightsStatus"
                        }
                    }
                    else {    
                        if (fLightsStatus == "off" || fLightsStatus == "closed") {
                            outputTxt = "Yes, the $lMatch is $fLightsStatus"
                        }
                        if (fLightsStatus == "on" || fLightsStatus == "open") {
                            outputTxt = "No, the $lMatch is currently $fLightsStatus"
                        	}
                        }
                    data.devices = devList
                    data.cmd = fLightStatus
                    data.deviceType = "lMatch"
                    state.lastAction = data
                    state.pContCmdsR = "feedback"
                    }
                }
            }
       	}
   	}
}

	// DIMMERS/LIGHTS INDIVIDUAL LEVELS //
        if  (((tts.contains("how bright") || tts.contains("what level is the") || tts.contains("what is the"))) && (tts.contains("light") || tts.contains("lamp") || tts.contains("iris"))) {
            gSwitches?.each { d -> 
                def dMatch = d.label.toLowerCase()
                if (tts.contains("$dMatch")) {
                def status = d.currentValue("switch")
                def level = d.currentValue("level")
                log.warn "the status of the $d is: $status"
                	if(status == "off") { outputTxt = "The $dMatch is currently off" }
					if(level == 0) { outputTxt = "The $dMatch is currently off" }
                    if(level > 0 || 33 <= 1) {
                    	if(status == "on") { outputTxt = "The $dMatch is currently set on low, at $level percent" }}
                    if(level > 33 || 66 <= 33) {
                    	if(status == "on") { outputTxt = "The $dMatch is currently set on medium, at $level percent" }}
                    if(level > 67) {
                    	if(status == "on") { outputTxt = "The $dMatch is currently set on high, at $level percent" }}
                }
            }
            if (parent.debug) log.debug "Dimmers levels requested: $outputTxt"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
        }    
          
        // CEILING FANS & FANS - SPEEDS AND LEVELS, ON & OFF //
        if (tts.contains("fan")) {
        if ((tts.contains("what speed") || tts.contains("what level") || tts.contains("how fast") || tts.contains("what is the")) && (tts.contains("fan") || tts.contains("fans"))) {
            if (parent.debug) log.debug "Ceiling fan speed requested"
            gFans?.each { f -> 
                def fMatch = f.label.toLowerCase()
                if (parent.debug) log.debug "fMatch is: $fMatch"
                if(tts.contains("${fMatch}")) {
                    def status = f.currentValue("switch")
                    def speed = f.currentValue("level")	
					if(speed == 0) { outputTxt = "The $fMatch is currently off" }
                    if(speed > 0 || 33 <= 1) { outputTxt = "The $fMatch is currently set on low, at $speed percent" }
                    if(speed > 33 || 66 <= 33) { outputTxt = "The $fMatch is currently set on medium, at $speed percent" }
                    if(speed > 67) { outputTxt = "The $fMatch is currently set on high, at $speed percent" }
                	if(status == "on" && tts.contains(" on")) {outputTxt = "Yes, The $fMatch is currently on" }
                    if(status == "on" && tts.contains(" off")) {outputTxt = "No, The $fMatch is currently on" }
                    if(status == "off" && tts.contains(" on")) {outputTxt = "No, The $fMatch is currently off" }
                    if(status == "off" && tts.contains("off ")) {outputTxt = "Yes, The $fMatch is currently off" }
                }
            }
            if (parent.debug) log.debug "Ceiling fan speed requested: $outputTxt"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
        	}
		}
        
        if (NetatmoTrue == false) {
        // TEMPERATURE //
        if (tts == "what is the temperature" || tts == "what's the temperature" || tts == "what's the temp"){
            if (parent.debug) log.debug "What is the temp requested"
            if(fTemp){
                def sensors = fTemp?.size()
                def tempAVG = fTemp ? getAverage(fTemp, "temperature") : "undefined device"          
                def currentTemp = tempAVG
                outputTxt = "The current temperature in the $app.label is $currentTemp degrees." 
                if (parent.debug) log.debug "Temperature status requested: $currentTemp"
                return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
            }
            else {
                outputTxt = "There are no temperature sensors selected, go to the Voice Companion Smart App and select one or more sensors"
                if (parent.debug) log.debug "No temperature sensors were found"
                return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]		
            }                            
        }

        // HUMIDITY //
        if (tts == "what is the humidity" || tts == "what's the humidity" || tts == "how humid is it"){
            if (parent.debug) log.debug "Humidity requested"
            if(fHum){
                def sensors = fHum?.size()
                def humidAVG = fHum ? getAverage(fHum, "humidity") : "undefined device"          
                def currentHum = humidAVG
                outputTxt = "The current humidity in the $app.label is $currentHum percent."
                if (parent.debug) log.debug "Humidity requested: $outputTxt"
                return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
            }
            else {
                outputTxt = "There are no humidity sensors selected, go to the Voice Companion Smart App and select one or more sensors"
                if (parent.debug) log.debug "No humidity sensors were found"
                return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]		
            }                            
        }		
	}
    
    /// CHECK FOR MOTION
        if (tts.contains("motion") || tts=="is there" || tts=="is anyone" || tts=="is there anyone" || tts=="is something moving" || tts=="is someone" || tts=="is there someone") {
            if (parent.debug) log.debug "Motion status requested"
            if (fMotion == null) {
                if (parent.debug) log.debug "There are no sensors selected for me to determine if there is motion in the ${app.label}"
                return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
            }
            if(fMotion != null) {
                def devListMotion = []
                def devStatus

                fMotion.each { deviceName ->
                    if (deviceName.latestValue("motion")=="active") {
                        String device = (String) deviceName
                        devListMotion += device
                    }
                }
                if (devListMotion.size() > 0) {
                    if (parent.debug) log.debug "devListMotionSize = $devListMotion.size"
                    if (tts.contains("check")) { 
                        outputTxt = "There is activity in the $app.label"
                        return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN] 
                    }
                    else {
                        outputTxt = "Yes, there is activity in the ${app.label}" 
                        return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN] 
                    }
                }
                else { 
                    outputTxt = "I am not detecting any activity in the ${app.label}"
                    if (parent.debug) log.debug "No motion detected"
                    return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN] 
                }
            }
            if (parent.debug) log.debug "Motion status requested: $outputTxt"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN] 
        }


        // POWER CONSUMPTION AEON SWITCHES
     /*      	if (tts.contains("how much power") || tts.contains("power usage")) {
                def result 
                def devList = []
                def currWatts = []
                def wattsUsed = []
                if (fPower) {
                devices.each { deviceName ->
                	String device = (String) deviceName
                    devList += device
                def sensor = fPower?.size()
                def powerAVG = deviceName ? getAverage(fPower, "power") : "undefined device"
                def longWatts = "(Consumed: ${fPower?.currentState('energy')?.value}kWh))\nMaximum of ${devices?.currentState('powerTwo')?.value}"
                currWatts = (deviceName?.currentState('power'))?.value//  IRIS SMART PLUG
                wattsUsed = (deviceName?.currentState('power'))?.value//  IRIS SMART PLUG
                currWatts = (deviceName?.currentState('powerDisp'))?.value  // AEON POWER METER
                wattsUsed = (deviceName?.currentState('energy'))?.value  // AEON POWER METER
                def watts = "${wattsUsed}"?.replaceAll("\\D", "") as double  // AEON POWER METER
                def costs = "${fCosts}" as double 
                def resetDate = (fPower?.currentState('powerOne'))?.value
                def total = ((watts*costs)/1000).round(2)
                log.info "devList = $devList"
                log.info "currWatts = $currWatts & the costs = $costs for a total cost of " + total + " using a total of " + wattsUsed + " watts"
                if (devList?.size() > 1) {
                	result = "There is currently an average of $powerAVG watts being used in the $app.label."// The total watts used has been $wattsUsed Kilowatts, for a total cost of ${total} U.S. dollars"
                	} 
                    else {
                    	result = "There is currently $powerAVG watts being used in the $app.label. The total watts used has been $wattsUsed Kilowatts, for a total cost of ${total} U.S. dollars" 
                        }
                        }
            	log.info "$fPower Device: power usage is --> $result"
            	outputTxt = stripBrackets(result ? " $result " : "")
            	return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
				}
            }*/


        // LIST DEVICES THAT ARE USING POWER    
        if (tts.contains("what devices") && tts.contains("power")) {
            if (fPower) {
            def devList = []
                fPower?.each { deviceName ->
                String device = (String) deviceName
                    devList += device
                    }
                ofPower?.each { deviceName ->
                String device = (String) deviceName
                    devList += device
					}
                outputTxt = "The following devices are using power in the $app.label, $devList"    
                }
                return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
				}
                
            
        // POWER CONSUMPTION IRIS SMART PLUGS
        if (tts.contains("how much power") || tts.contains("power usage")) {
            def result 
            def devList = []
            //   def currWatts = []
            //   def wattsUsed = []
            if (fPower) {
                fPower.each { deviceName ->
                    String device = (String) deviceName
                    devList += device

                    log.debug "The current Iris device is: $deviceName && the power being used is " + fPower.currentValue("power") 
                    def sensor = fPower?.size()
                    def powerAVG = deviceName ? getAverage(fPower, "power") : "undefined device"
                    //      def longWatts = "(Consumed: ${fPower?.currentState('energy')?.value}kWh))\nMaximum of ${devices?.currentState('powerTwo')?.value}"
                    def currWatts = (deviceName?.currentValue('power'))//?.value//  IRIS SMART PLUG
                    def wattsUsed = (deviceName?.currentValue('sensor'))//?.value//  IRIS SMART PLUG
                    //      def watts = "${wattsUsed}"?.replaceAll("\\D", "") as double  // AEON POWER METER
                    def costs = "${fCosts}" as double 
                        //      def resetDate = (ofPower?.currentState('powerOne'))?.value
                        //      def total = ((watts*costs)/1000).round(2)
                        //     log.info "devList = $devList"
                        //      log.info "currWatts = $currWatts & the costs = $costs for a total cost of " + total + " using a total of " + wattsUsed + " watts"
                        if (devList?.size() > 1) {
                            result = "There is currently an average of $powerAVG watts being used in the $app.label."// The total watts used has been $wattsUsed Kilowatts, for a total cost of ${total} U.S. dollars"
                        } 
                    else {
                        result = "There is currently $currWatts watts being used in the $app.label."// The total watts used has been $wattsUsed Kilowatts, for a total cost of ${total} U.S. dollars" 
                    }
                }
                log.info "$fPower Iris Device: power usage is --> $currWatts"
                outputTxt = stripBrackets(result ? " $result " : "")
                return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
            }
        }

        if (tts.contains("thermostat")) {
            def tStat1 = Thermostat1
            def temp1 = (tStat1?.currentValue("temperature"))
            def setPC1 = (tStat1?.currentValue("coolingSetpoint"))
            def setPH1 = (tStat1?.currentValue("heatingSetpoint"))
            def mode1 = (tStat1?.currentValue("thermostatMode"))
            def oper1 = (tStat1?.currentValue("thermostatOperatingState"))
            def tStat2 = Thermostat2
            def temp2 = (tStat2?.currentValue("temperature"))
            def setPC2 = (tStat2?.currentValue("coolingSetpoint"))
            def setPH2 = (tStat2?.currentValue("heatingSetpoint"))
            def mode2 = (tStat2?.currentValue("thermostatMode"))
            def oper2 = (tStat2?.currentValue("thermostatOperatingState"))
		//THERMOSTAT1
        if (Thermostat1 && Thermostat2 == null) {
        if ("${mode1}" == "auto") 
        	outputTxt = "The ${tStat1} temperature is ${temp1}°, it is set to ${mode1} mode, with ${setPH1}° for heating, and ${setPC1}° for cooling. The system is currently ${oper1}."
        if ("${mode1}" == "cool")
            outputTxt = "The ${tStat1} temperature is ${temp1}°, it is in ${mode1} mode and is set to ${setPC1}°. The system is currently ${oper1}."
        if ("${mode1}" == "heat")
            outputTxt = "The ${tStat1} temperature is ${temp1}°, it is in ${mode1} mode and is set to ${setPC1}°. The system is currently ${oper1}."
        if ("${mode1}" == "off")
        	outputTxt = "The ${tStat1} thermostat is currently ${mode1}, and the temperature is ${temp1}°." 
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
            }
		//THERMOSTAT2
        if (Thermostat2 && Thermostat1 == null) {
        if ("${mode2}" == "auto") 
        	outputTxt = "The ${tStat2} temperature is ${temp2}°, it is set to ${mode2} mode, with ${setPH2}° for heating, and ${setPC2}° for cooling. The system is currently ${oper2}."
        if ("${mode1}" == "cool")
            outputTxt = "The ${tStat2} temperature is ${temp2}°, it is in ${mode2} mode and is set to ${setPC2}°. The system is currently ${oper2}."
        if ("${mode1}" == "heat")
            outputTxt = "The ${tStat2} temperature is ${temp2}°, it is in ${mode2} mode and is set to ${setPC2}°. The system is currently ${oper2}."
        if ("${mode1}" == "off")
        	outputTxt = "The ${tStat2} thermostat is currently ${mode2}, and the temperature is ${temp2}°." 
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]			
            }
		//BOTH THERMOSTATS
        if (Thermostat1 != null && Thermostat2 != null) {
        	outputTxt = "The ${tStat1} temperature is ${temp1}°, it is set to ${mode1} mode, with ${setPH1}° for heating, and ${setPC1}° for cooling.  The ${tStat1} system is currently ${oper1}. " + 
        	" The ${tStat2} temperature is ${temp2}°, it is set to ${mode2} mode, with ${setPH2}° for heating, and ${setPC2}° for cooling. The ${tStat2} system is currently ${oper2}."
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
            }
		}

    // NETATMO WEATHER STATION HANDLER FOR FEEDBACK
    if (NetatmoTrue) {
        if (parent.debug) log.debug "Netatmo Weather Station called"
        def WindMaxTime = fWind?.currentValue("date_max_wind_str")
        def WindMax = fWind?.currentValue("max_wind_str")
        def WindGust = fWind?.currentValue("GustStrength")
        def WindSpeed = fWind?.currentValue("WindStrength")
        def WindDir = fWind?.currentValue("WindDirection")
        def WindUpdate = fWind?.currentValue("lastupdate")
        def RainTotal = fRain?.currentValue("rainSumDay")
        def RainFall = fRain?.currentValue("rain")
        def RainUpdate = fRain?.currentValue("lastupdate")
        def humidity = fOutDoor?.currentValue("humidity")
        def currTemp = fOutDoor?.currentValue("temperature")
        def minTemp = fOutDoor?.currentValue("min_temp")
        def maxTemp = fOutDoor?.currentValue("max_temp")
        def trend = fOutDoor?.currentValue("temp_trend")
        def outdoorUpdate = fOutDoor?.currentValue("lastupdate")

            if (tts.contains("wind speed")) {
            	if (WindSpeed == 0) { outputTxt = "There is currently not any wind blowing" }
            	if (WindSpeed > 0) { outputTxt = "At $WindUpdate, I recorded the wind blowing at $WindSpeed miles per hour, at $WindDir. I've also recorded a wind gust of $WindGust miles per hour, " +
                	"with a max wind speed of $WindMax miles per hour recorded at $WindMaxTime ." }
                    }
        	if (tts.contains("wind blowing")) {
            	if (WindSpeed == 0) { outputTxt = "No, the wind is not currently blowing" }
            	if (WindSpeed > 0) { outputTxt = "Yes, the wind is currently blowing at $WindSpeed miles per hour, at $WindDir." }
        	}

        if (tts=="is it raining") {
            if (RainFall == 0) { outputTxt = "No, it is not currently raining" } 
            if (RainFall > 0) { outputTxt = "Yes, it is raining" } }
        if (tts=="has it rained" || tts=="did it rain" || tts.contains("how much has it rained")) {
            if (RainFall == 0) { outputTxt = "There has not been any rain recorded in the past 24 hours" } 
            if (RainFall > 0) { outputTxt = "As of $RainUpdate, there has been $RainTotal inches of rain today" } }
        if (tts.contains("will it rain") || tts.contains("going to rain")) {
            outputTxt = "I'm sorry, I can not forecast the rain. Please simply say, Alexa, is it going to rain" }

        if (tts=="what's the temperature" || tts=="what is the temperature") {
            outputTxt = "At $outdoorUpdate today, the temperature was $currTemp degrees and the temperature is currently trending $trend" }
        if (tts.contains("temperature and humidity") || tts.contains("humidity and temperature") || tts.contains("temperature and the humidity")) {
            outputTxt = "The current temperature is $currTemp and the humidity is $humidity percent" }

        if (tts=="what's the humidity" || tts=="what is the humidity") {
            outputTxt = "The humidity is currently $humidity percent" }

        if (tts.contains("what is the weather like") || tts.contains("what's the weather like") || tts=="how is it" || tts.contains("what's the weather") || tts.contains("what's it like outside") ||
        	tts.contains("what is the weather")) {    
            outputTxt = "At $outdoorUpdate today, the temperature was $currTemp degrees, $minTemp degrees was the low, and $maxTemp degrees was the high. " +
                "Currently the temperature is trending $trend, the humidity is $humidity percent, and the wind is blowing at $WindSpeed miles per hour."
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]	
        }
        if (tts.contains("feel like")) {
        	def feel = fWeather.currentValue("feelsLike")
            outputTxt = "With the current conditions it feels like it is $feel degrees"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]	
		}
    }
               
    //  TASK TRACKER FEEDBACK
    if (tts.startsWith("was") || tts.startsWith("has") || tts.startsWith("when") || tts.startsWith("did")) { // || tts.startsWith("what")) {
        if (tts.contains("she") || tts.contains("he") || tts.contains("has") || tts.contains("was") || tts.contains("were") || tts.contains("did") || tts.contains("it")) {
            if (tts.contains("${trackerOne1}".toLowerCase()) && state.trackerOne != null ) {
                if (t1notify){ outputTxt = state.trackerOne + " , and there is a reminder scheduled for " + state.sched }
                else { outputTxt = state.trackerOne } }
            if (tts.contains("${trackerTwo1}".toLowerCase()) && state.trackerTwo != null ) {
                if (t2notify){ outputTxt = state.trackerTwo + " , and there is a reminder scheduled for " + state.sched2 }
                else { outputTxt = state.trackerTwo } }
            if (tts.contains("${trackerThree1}".toLowerCase()) && state.trackerThree != null ) {
                if (t3notify){ outputTxt = state.trackerThree + " , and there is a reminder scheduled for " + state.sched3 }
                else { outputTxt = state.trackerThree } }
            if (tts.contains("${trackerFour1}".toLowerCase()) && state.trackerFour != null ) {
                if (t4notify){ outputTxt = state.trackerFour + " , and there is a reminder scheduled for " + state.sched4 }
                else { outputTxt = state.trackerFour } }
        }
        else {outputTxt = "I'm sorry, I have not been given this information"}
        return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]	
    	}
    }
   	return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
	}
    
    
/******************************************************************************
	 CONTROL SUPPORT - DATE & TIME FUNCTIONS											
******************************************************************************/
private getTimeVariable(date, type) {
	def currTime
    def currDate
    def currDateShort
    def String tText = (String) null    
    def String duration = (String) null
    def today = new Date(now()).format("EEEE, MMMM d, yyyy", location.timeZone) // format("EEEE, MMMM d, yyyy") REMOVED YEAR 2/8/2017
    def yesterday = new Date(today -0.1).format("EEEE, MMMM d, yyyy", location.timeZone)
	def time = new Date(now()).format("h:mm aa", location.timeZone)
    
    //currTime = new Date(date + location.timeZone.rawOffset).format("hh:mm aa")
    currTime = new Date(date).format("h:mm aa", location.timeZone)
	currDate = new Date(date + location.timeZone.rawOffset).format("EEEE, MMMM d, yyyy")
	currDateShort = new Date(date + location.timeZone.rawOffset).format("EEEE, MMMM d")
    currDate = today == currDate ? "today" : yesterday == currDate ? "yesterday" : currDateShort
		def endTime = now() + location.timeZone.rawOffset
    	def startTime = new Date(date + location.timeZone.rawOffset)
    	startTime = startTime.getTime()
    int hours = (int)((endTime - startTime) / (1000 * 60 * 60) )
    int minutes = (int)((endTime - startTime) / ( 60 * 1000))
    duration = minutes < 60 ? minutes + " minutes" : hours + " hours"
    tText = currDate + " at " + currTime
  	return ["currTime":currTime, "currDate":currDate, "tText":tText, "duration": duration] 
 
}    
/******************************************************************************************************
	INCOMING TTS PROCESSING FOR DELAYS, COMMANDS, AND MESSAGES
******************************************************************************************************/
def profileEvaluate(params) {
    
    //Output Variables
    def tts = params.ptts
    def pTryAgain = true
    def pPIN = false
    def pShort = false
    def pContCmds = false
    def String pContCmdsR = (String) null
    def String outputTxt = (String) null 
    def String scheduler = (String) null     
    def String ttsR = (String) null
    def String command = (String) null
    def String deviceType = (String) null
    def String colorMatch = (String) null
	
//    outputTxt =  "Incidents test: " + getShmIncidents()
//    return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]

    // SKIPS PARSING AND SEND ENTIRE INCOMING TTS AS AN OUTGOING MESSAGE 
    if (tts.startsWith("hey ")) {  
        def ttsText = tts.toLowerCase()
        ttsHandler(tts)
        outputTxt = "Ok, your message has been sent to $app.label"
        return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
    }			
            
    // PARSE OUT DELAY TIME 
    else if ((tts.findAll("[0-999999]")) && (tts.contains("minute") || tts.contains("minutes") || tts.contains("hour") || tts.contains("hours") || tts.contains(" a.m.") || tts.contains(" p.m."))) {
        //  def timer = ttsText.replaceAll("\\D+","").toInteger();
        //     ttsText = ttsText.replaceAll("\\b and.*\\b", "") 
        //     ttsText = ttsText.replaceAll("\\b in.*\\b", "") 
        state.timerHours = 0
        state.timerMins = 0
		
        // ALLOWS TURN ON/OFF OF LIGHT FOR XX AMOUNT OF TIME AND THEN IT IS RESTORED
        if (tts.contains("for") && ((tts.contains("minute") || tts.contains("minutes")))) {
                def tts1 = tts.replaceAll("\\b for .*\\b", "")
                log.warn "The tts is now: $tts"
                def newttsText = tts.replaceAll("\\b${tts1}\\b", "")
                newttsText = 0 + newttsText
                def timer = newttsText.replaceAll("\\D+","").toInteger();
                log.warn "minutes timer = $timer"
                state.timerMins = timer * 60 
                timer = state.timerMins
                tts = tts1
                beginProcess(params, tts)
                	if (tts.contains("increase")) {
                    	tts = tts.replaceAll("increase ", "decrease ")
                		timerMaker(timer, tts, params)
                        }
                    else if (tts.contains("decrease")) {
                    	tts = tts.replaceAll("decrease ", "increase ")
                        timerMaker(timer, tts, params)
                        }
                	if (tts.contains("turn on")) {
                    	tts = tts.replaceAll("turn on ", "turn off ")
                		timerMaker(timer, tts, params)
                        }
                    else if (tts.contains("turn off")) {
                    	tts = tts.replaceAll("turn off ", "turn on ")
                        timerMaker(timer, tts, params)
                        }
                	if (tts.contains("start")) {
                    	tts = tts.replaceAll("start ", "stop ")
                		timerMaker(timer, tts, params)
                        }
                    else if (tts.contains("stop")) {
                    	tts = tts.replaceAll("stop ", "start ")
                        timerMaker(timer, tts, params)
                        }
                outputTxt = "Ok, I will $params.ptts"
                timerMaker(timer, tts, params)
                return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
            }
		
        // SCHEDULES A CRON TIMER TO TURN ON/OFF LIGHTS AT A SPECIFIC TIME
        if (tts.contains("a.m.") || tts.contains("p.m.") || tts.contains("create an alarm ")) {
            def tts1 = tts.replaceAll("\\b in .*\\b", "")
            def timer = tts.replaceAll("\\D+","").toInteger();
            tts = tts1
            outputTxt = timerMaker(timer, tts, params)
            //outputTxt = "Ok, I will $params.ptts"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
        }       

        // SCHEDULES A DELAY OF HOURS AND MINUTES
        if ((tts.contains("hours") || tts.contains("hour")) && (tts.contains("minute") || tts.contains("minutes"))) {
            state.timerHours = hours(tts)
            state.timerMins = minutes(tts)
            def tts1 = tts.replaceAll("\\b in .*\\b", "")
            def timer = state.timerHours + state.timerMins
            log.debug "Hours/Minutes timer = $timer minutes or $timer/60 hours"
            tts = tts1
            timerMaker(timer, tts, params)
            outputTxt = "Ok, I will $params.ptts"
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
        }

        // SCHEDULES A DELAY OF HOURS ONLY
        if ((tts.contains("hour") || tts.contains("hours")) && (!tts.contains("minutes") || !tts.contains("minute"))) { 
            def newTts = tts.split("and").each { t -> 
                tts = t.toLowerCase()
                def tts1 = tts.replaceAll("\\b in .*\\b", "")
                log.warn "The tts is now: $tts"
                def newttsText = tts.replaceAll("\\b${tts1}\\b", "")
                newttsText = 0 + newttsText
                def timer = newttsText.replaceAll("\\D+","").toInteger();
                log.warn "hours timer = $timer"
                state.timerHours = timer * 3600 
                timer = state.timerHours
                timerMaker(timer, tts, params)
                outputTxt = "Ok, I will $params.ptts"
                return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
            }
        }

        // SCHEDULES A DELAY OF MINUTES ONLY
        if ((tts.contains("minute") || tts.contains("minutes")) && (!tts.contains("hours") || !tts.contains("hour"))) {
            def newTts = tts.split(" and").each { t -> 
                tts = t.toLowerCase()
                def tts1 = tts.replaceAll("\\b in .*\\b", "")
                log.warn "The tts is now: $tts"
                def newttsText = tts.replaceAll("\\b${tts1}\\b", "")
                newttsText = 0 + newttsText
                def timer = newttsText.replaceAll("\\D+","").toInteger();
                log.warn "minutes timer = $timer"
                state.timerMins = timer * 60 
                timer = state.timerMins
                tts = tts1
            //    if (timer == "0") {
                	
                timerMaker(timer, tts, params)
                outputTxt = "Ok, I will $params.ptts"
                return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
            }
        }    
    }
    else {  // PARSER BEGINS - SPLITS INCOMING TTS INTO A LIST OF COMMANDS
        def newTts = tts.split(" and").each { t -> 
            def ttsText = t.toLowerCase()
            log.info "ttsText is: $ttsText"
            tts = ttsText
        //    if (tts.contains("how bright")) {
        //    	outputTxt = profileFeedbackEvaluate(params)
        //        }
        //        else {
            outputTxt = beginProcess(params, tts)}
            return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
       // } 
    }    
    return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
}    

// CREATES HOURS TIMER FROM TTS
def hours(tts) {
    state.hrTimer = tts.replaceAll("\\band.*\\b", "")
    def testing = (state.hrTimer.findAll("[0-999999]"))
    def timer = state.hrTimer.replaceAll("\\D+","").toInteger();
    state.timerHours = timer * 3600 
    timer = state.timerHours
    return timer
}

// CREATES MINUTES TIMER FROM TTS
def minutes(tts) {
    def timer = tts.replaceAll("\\b${state.hrTimer}\\b", "")
    timer = timer.replaceAll("\\D+","").toInteger();
    timer = timer * 60
    state.timerMins = timer 
    return timer
}


// SCHEDULES TIMERS AND ORGANIZES DELAYED ACTIONS
def timerMaker(timer, tts, params) {
    log.warn "timer is: $timer in timerMaker"
	def ptts = params.ptts
    def outputTxt
	if (tts.contains(" for")) {
    	outputTxt = "Ok, I will $tts"
        state.resetTTS4 = tts
        runIn(timer, resetTts4, [overwrite:false])
        return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
    	}

    if (tts.contains("a.m.") || tts.contains("p.m.") || tts.contains("create an alarm ")) {
                
        def timerL = "$timer".length()
        if ("$timerL" == "3") {
        	timer = "0" + timer
            }
            else if ("$timerL" == "1") {
            timer = "0" + timer + "00"
            }
            else if ("$timerL" < "3") {
            	timer = timer + "00"
                }
        timer = timer.toString()
        def mnTime = timer.substring(2)
        def hrTime = timer[-4..-3]
        def outputhr = hrTime
        if ("$hrTime" <= "11" && tts.contains("p.m.")) {
        	hrTime = hrTime as BigDecimal 
            hrTime = hrTime + 12
            log.warn "hrTime is: $hrTime"
            }
        if ("$hrTime" == "12" && tts.contains("a.m.")) { 
        	hrTime = hrTime as BigDecimal 
            hrTime = hrTime - 12
            log.warn "hrTime is: $hrTime"
            }
            
        tts = tts.replaceAll("\\b at.*|at \\b", "")
        state.resetTTS5 = tts
        log.debug "tts = $state.resetTTS5"
      	
		def yyyy = new Date(now()).format("yyyy")
		def MM = new Date(now()).format("MM")
		def dd = new Date(now()).format("dd")
        def time = hrTime+":" + mnTime+":" + "00"
        def timeSchedule = hhmmss(time)
        def schedule = "${yyyy}-${MM}-${dd}T${timeSchedule}"
		log.warn "tts contains: $tts"
    
 //   tts.split("and").each { t -> 
    if (!tts.contains("create an alarm")) {
    	log.warn "creating an ST schedule"
        runOnce(schedule, resetTts5)
        }
 //   }
	
    if (tts.contains("create an alarm")) {
    	String alarmLbl = "tts"
        String alarmDate = "${yyyy}-${MM}-${dd}"
        String alarmTime = "$hrTime:$mnTime"
        log.debug "alarmTime is: $alarmTime"
        	if(sSpeaker == null) {
            	def result = "I am sorry, but it seems that you have not selected an echo device to create an alarm on"
                return result
                }
                else {
        sSpeaker?.createAlarm(alarmLbl, alarmDate, alarmTime)
        def result = "Ok, I am creating an alarm in the $app.label for $alarmTime on $alarmDate"
      //  return result
     //   }
        if (tts.contains("create an alarm and ")) {
        log.warn "creating a schedule also"
        	runOnce(schedule, resetTts5)
            }
        return result
        }
        log.warn "$result"
        return result
        }           
    
	log.debug "5th delay time will perform: $state.resetTTS5"
			if (ptts.contains(" a.m.")) {
        		def result = "ok, I will $state.resetTTS5 at $hrTime $mnTime a.m."
                return result
                }
            if (ptts.contains(" p.m.")) {
        		def result = "ok, I will $state.resetTTS5 at $outputhr $mnTime p.m."
                return result
                }
            	log.debug "result is: $result"
    
    }

	if (timer == 0) {  // PASSES THE NON TIMER PART OF COMPOUND TTS TO THE COMMAND PROCESS
    	outputTxt = "Ok, I will $ttsText"
        state.resetTTS1 = tts
        beginProcess(params, tts)
        //resetTts1(tts)
        return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
    	}
       
    if (timer == 60 && (!tts.contains("hour") || !tts.contains("hours"))) {  // SCHEDULES DELAY WHEN IT IS FOR ONE MINUTE ONLY
    	outputTxt = "Ok, I will $ttsText"
        state.resetTTS1 = tts
        runIn(timer, resetTts1, [overwrite:true])
        log.debug "1st delay time will perform: $state.resetTTS1"
        return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
    	}
    
	if (timer > 60 && (!tts.contains("hour") || !tts.contains("hours"))) {   // SCHEDULES DELAYS WHEN GREATER THAN ONE MINUTE
        outputTxt = "Ok, I will $tts" 
        state.resetTTS2 = tts
        runIn(timer, resetTts2, [overwrite:true])
        log.debug "2nd delay time will perform: $state.resetTTS2"
        return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
    }
    
    if (tts.contains("hour") || tts.contains("hours") && (!tts.contains("minute") || !tts.contains("minutes"))) {   // SCHEDULES DELAYS FOR HOURS
        outputTxt = "Ok, I will $tts" 
        state.resetTTS3 = tts
        runIn(timer, resetTts3, [overwrite:true])
        log.debug "3rd delay time will perform: $state.resetTTS3"
        return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
    }
}
private hhmmss(time, fmt = "HH:mm:ss.SSSZ") {
	def t = timeToday(time, location.timeZone)
    def f = new java.text.SimpleDateFormat(fmt)
    f.setTimeZone(location.timeZone ?: timeZone(time))
	f.format(t)
}

// 1st DELAYED COMMAND STARTS HERE AFTER DELAY
def resetTts1(tts) {  // PROCESSES THE DELAYED COMMAND AND INIATES THE PROCESS FOR ONE MINUTE DELAYS
    if(parent.debug) log.info "Delayed command timer #1 complete, beginning processing"
    tts = state.resetTTS1
    beginProcess(params, tts)
}
// 2nd DELAYED COMMAND STARTS HERE AFTER DELAY
def resetTts2(tts) {  // PROCESSES THE DELAYED COMMAND AND INIATES THE PROCESS FOR > THAN ONE MINUTE DELAYS
    if(parent.debug) log.info "Delayed command timer #2 complete, beginning processing"
    tts = state.resetTTS2
    beginProcess(params, tts)
}
// 3rd DELAYED COMMAND STARTS HERE AFTER DELAY
def resetTts3(tts) {  // PROCESSES THE DELAYED COMMAND AND INIATES THE PROCESS FOR HOURS & MINUTES DELAYS
    if(parent.debug) log.info "Delayed command timer #3 complete, beginning processing"
    tts = state.resetTTS3
    beginProcess(params, tts)
}
// 4th DELAYED COMMAND STARTS HERE AFTER DELAY
def resetTts4(tts) {  // TURNS THE LIGHTS BACK ON OR OFF AFTER THE DELAYS
    if(parent.debug) log.info "Delayed command timer #4 complete, beginning processing"
    tts = state.resetTTS4
    beginProcess(params, tts)
}
// 5th DELAYED COMMAND STARTS HERE AT A CERTAIN TIME
def resetTts5(tts) {  // PROCESSES THE DELAYED COMMAND AND INIATES THE PROCESS FOR CERTAIN TIME SCHEDULES
    if(parent.debug) log.info "Delayed command timer #5 complete, beginning processing"
    tts = state.resetTTS5
    beginProcess(params, tts)
}

// LIST OF COMMANDS FOR LATER USE
private cmdsToList(String ttsText, String splitStr) {    
    return ttsText?.split(splitStr)?.collect { it?.toLowerCase() }
}

   
/******************************************************************************************************
	SPEECH AND TEXT BEGIN PROCESSING 
******************************************************************************************************/
def beginProcess(params, tts) {
    if (parent.debug) log.info "beginProcess has commenced: $tts"
    def deviceId = parent.state.deviceId
    def childName = app.label 
    //Output Variables
    def pTryAgain = true
    def pPIN = false
    def pShort = false
    def pContCmds = false
    def String pContCmdsR = (String) null
    def String outputTxt = (String) null 
    def String scheduler = (String) null     
    def String ttsR = (String) null
    def String command = (String) null
    def String deviceType = (String) null
    def String colorMatch = (String) null

	// BLUETOOTH CONNECTION
    if (tts == ("connect to my phone")) {
    //	sSpeaker.connectBluetooth()
    	def btDevices = sSpeaker.connectBluetooth("Jason's Note 8")
        outputTxt = "Ok, connecting to your phone in the $app.label"
        return outputTxt
        }
    // BLUETOOTH DISCONNECT
    if (tts == ("disconnect my phone")) {
    	sSpeaker.disconnectBluetooth()
        outputTxt = "Ok, disconnecting your phone from the $app.label"
        return outputTxt
        }
	// STOP MUSIC PLAYING ON ECHO SPEAKS DEVICES
    if (tts == ("stop the music")) {
    	sSpeaker.pause()
            outputTxt = "Ok, I am stopping the music in the $app.label"
             return outputTxt  
             }
	// PLAY MUSIC PLAYING ON ECHO SPEAKS DEVICES
    if (tts == ("play music") || tts == ("play pandora") || tts.contains("on pandora") || tts.contains("on amazon music")) {
    	def music = tts.replaceAll("\\b in .*\\b", "")
        music = music.replaceAll("play", "").toUpperCase() as String 
        log.warn "Playing music: $music"
        sSpeaker.searchPandora(music)
            outputTxt = "Ok, I am playing $music in the $app.label"
             return outputTxt  
             }
	// CANCEL ALL SCHEDULED TIMERS/DELAYS
    if (tts.contains("cancel the delay") || tts.contains("cancel the timer")) {
        unschedule(resetTts)
        outputTxt = "Ok, I have cancelled the previously scheduled delayed actions"
        if (parent.debug) log.warn "All delayed commands have been cancelled"
        return outputTxt    }
	
    // EXECUTE WEBCORE PISTONS
	if (tts.contains("execute piston") || tts.contains("run piston")) {
		if (myPiston) {
    		parent.webCoRE_execute(myPiston)
			outputTxt = "ok, I have executed the piston, $myPiston"
        	if (parent.debug) log.info "executing piston name = $myPiston"
        	return outputTxt 		}
	}
    // TURN ON/OFF SMART HOME MONITOR
    if (tts.contains("turn on the alarm") || tts.contains("turn off the alarm")) {
        outputTxt = securityHandler(tts)
        if (parent.debug) log.info "SHM change requested: $outputTxt"
        return outputTxt 
        }
    // CHANGES THE LOCATION MODE
    if (tts?.contains("set the mode to")) {
        def currMode = location.currentMode 
        mMode?.each { m -> 
            def mMatch = m.toLowerCase() 
            if(tts.contains("${mMatch}")) {
                if("${currMode}" != "${m}") {
                    def newMode = "${m}"
                    setLocationMode(m)
                    outputTxt = "I have set the mode to $m mode."
                }
            }
        }
        if (parent.debug) log.info "Location mode change requested: $outputTxt"
        return outputTxt
        }
    // STARTS CONVERSATION MODE IN THE ROOM
    if (tts?.contains("start the conversation") || tts.contains("start a conversation")) {
        state.pContCmds = true
        outputTxt = "Ok, activating conversational features. To deactivate just say, stop the conversation"
        if (parent.debug) log.debug "Start Conversation mode requested: $outputTxt"
        return outputTxt 
        }
    // STOPS CONVERSATION MODE IN THE ROOM
    if (tts?.contains("stop the conversation")) {
        state.pContCmds = false
        outputTxt = "Ok, disabling conversational features. To activate just say, start the conversation"
        if (parent.debug) log.debug "Stop Conversation mode requested: $outputTxt"
        return outputTxt 
        }
    // TURNS ON THE TELEVISION 
    if (tts?.contains("turn on the tv") || tts.contains("turn on the television")) {
        state.pContCmds = false
        outputTxt = "Ok, turning on the tv in the $app.label"
        sTV.on()
        return outputTxt 
        }
    // TURNS OFF THE TELEVISION 
    if (tts?.contains("turn off the tv") || tts.contains("turn off the television")) {
        state.pContCmds = false
        outputTxt = "Ok, turning off the tv in the $app.label"
        sTV.off()
        return outputTxt 
        }
    // TURNS ON THE FIREPLACE 
    if (tts?.contains("turn on the fireplace")) {
        state.pContCmds = false
        outputTxt = "Ok, turning on the fireplace in the $app.label"
        gFire.on()
        return outputTxt 
        }
    // TURNS OFF THE FIREPLACE 
    if (tts?.contains("turn off the fireplace")) {
        state.pContCmds = false
        outputTxt = "Ok, turning off the fireplace in the $app.label"
        gFire.off()
        return outputTxt 
        }

else {
    	outputTxt = deviceCmd(params, tts)
    	return outputTxt
    }    
}    
	
/******************************************************************************************************
	INDIVIDUAL DEVICE COMMANDS
******************************************************************************************************/
def deviceCmd(params, tts) {
    if (parent.debug) log.info "The deviceCmd method has been activated with this message: $tts and this original spoken command: $params.ptts"
    def outputTxt = null
    def deviceType
    def getCMD
    def command
    def mMatch = null
	def pContCmdsR
    
    if (tts == "reset the system" || tts == "reset the alarm") {
    	outputTxt = ttsHandler(tts)
        return outputTxt
        }
    
    if (tts == "reset the q ") {
    	tts = "reset the queue"
        }
    
    getCMD = getCommand(tts)
    deviceType = getCMD.deviceType
    command = getCMD.command
    if (parent.trace) log.trace "I have received a control command: ${command}, deviceType:  ${deviceType}"
             if(tts.contains("TV")) {
            	mMatch = mMatch.toUpperCase()
                }

	//  CONTROL HANDLER - (CONTROL PARSING ENGINE) 
/*		def fDevice = tts.contains("notifications") ? gNotDisable : tts.contains("automations") ? gDisable : tts.contains("eon") ? fPower : tts.contains(" iris") ? gSwitches : 
        tts.contains("vent") ? gVents : tts.contains("light") ? gSwitches :  tts.contains("garage") ? gGarage : tts.contains("door") ? fDoors : tts.contains("window") ? fWindows : tts.contains("fireplace") ? gFire : 
        tts.contains("fan") ? gFans : tts.contains("lights") ? gSwitches : tts.contains("TV") ? fSwitches : tts.contains("motion") ? fMotion : tts.contains("lock") ? gLocks : 
        tts.contains("shade") ? gShades : tts.contains("curtains") ? gShades : tts.contains("blinds") ? gShades : tts.startsWith("who") ? fPresence :
        tts.contains("television") ? sTV : tts.contains("lamp") ? gSwitches : tts.contains("automations") ? gSwitches : tts.contains("spotlight") ? gSwitches : 
        tts.contains("spot") ? gSwitches : tts.contains("outlet") ? gSwitches : tts.contains("strip") ? gSwitches : tts.contains("tv") ? sTV : null

        def fValue = tts.contains("notifications") ? "switch" : tts.contains("automations") ? "switch" : tts.contains("vent") ? "switch" : tts.contains("light") ? "switch" : tts.contains("garage") ? "door" :
        tts.contains("door") ? "contact" : tts.contains("window") ? "contact" : tts.contains("fan") ? "switch" : tts.contains("lights") ? "switch" : tts.contains("eon") ? "switch" : 
        tts.contains("iris") ? "switch" : tts.contains("television") ? "switch" : tts.contains("lock") ? "lock" : tts.contains("shade") ? "windowShade" : tts.contains("blind") ? "windowShade" :  
        tts.contains("who") ? "presence" : tts.contains("curtains") ? "windowShade" : tts.contains("fireplace") ? "switch" : tts.contains("tv") ? "switch" : tts.contains("tv") ? "switch" :
        tts.contains("lamp") ? "switch" : tts.contains("spotlight") ? "switch" : tts.contains("spot") ? "switch" : tts.contains("outlet") ? "switch" : tts.contains("strip") ? "switch" :  null

        def fName = tts.contains("notifications") ? "notification" : tts.contains("automations") ? "automation" : tts.contains("motion") ? "motion sensors" : tts.contains("tv") ? "TV" :
        tts.contains("vent") ? "vent" : tts.contains("lock") ? "lock" : tts.contains("garage door") ? "garage door" : tts.contains("door") ? "door" : tts.contains("window") ? "window" : tts.contains("fan") ? "fan" : 
        tts.contains("lights") ? "lights" : tts.contains("light") ? "light" : tts.contains("shade") ? "shade" : tts.contains("blind") ? "blind" : tts.contains("curtains") ? "curtain" : 
        tts.contains("fireplace") ? "fireplace" : tts.contains("television") ? "TV" : tts.contains("lamp") ? "lamp" : tts.contains("spotlight") ? "spotlight" : tts.contains("spot") ? "spot" : 
        tts.contains("outlet") ? "outlet" : tts.contains("strip") ? "strip" : tts.contains("iris") ? "iris" : null

        def fCommand = tts=="who is at home" ? "present" : tts=="who is home" ? "present" : tts=="who is not home" ? "not present" : tts=="who is not at home" ? "not present" : 
        tts.contains("open") ? "open" : tts.contains("closed") ? "closed" : tts.contains(" on") ? "on" : tts.contains("off") ? "off" : tts.contains("start") ? "on" : 
        tts.contains("stop") ? "off" : null

        if (tts.contains("check") && tts.contains("light")) { fCommand = "on" }
        if (tts.contains("motion")) { fCommand = "active" }
        if (tts.contains("check")) {
            if (tts.contains("lock") || tts.contains("door") || tts.contains("window") || tts.contains("vent") || tts.contains("shades") || tts.contains("blind") || tts.contains("curtain")) {
                fCommand = "open" }}
		
        if (parent.debug) log.info "Received the following Control structure: (fDevice = $fDevice), (fValue = $fValue), (fName = $fName), (fCommand = $fCommand)"
        
        //  BUILDS DEVICE LISTS        
            def devList = []
                fDevice.each { deviceName ->
                    if (deviceName.latestValue("${fValue}")!="${fCommand}") {
                        String device  = (String) deviceName
                        devList += device
                        if (parent.debug) log.debug "devList = $devList"
                        }
            
         // BEGINS DEVICE ACTIONS
         	fDevice?.each { m -> 
                mMatch = m.label.toLowerCase()
                log.warn "mMatch is: $mMatch"
                def lvlNow = m.latestValue("level")
                if(tts.contains("${mMatch}") || tts.contains("lights")) {
                    if (fCommand == "on" || fCommand == "off") {
                        m."$fCommand"()
                        outputTxt = "ok, I will $params.ptts"
                        return outputTxt
            			}
            		}
            	}
            }
            return outputTxt
            }
        
        */
        




	if (command == "undefined" || command == null) {
    if (deviceType == "light" || deviceType == "message" || (deviceType == null && command == null)) { //if ((!sonosDevice && !synthDevice)) {   
        state.lastTime = new Date(now()).format("h:mm aa, dd-MMMM-yyyy", location.timeZone)
        outputTxt = ttsHandler(tts) 
     //   ttsHandler(tts)
        pContCmdsR = "profile"
        return outputTxt
    	}
    }

    // AUTOMATION DISABLE SWITCHES (GROUPS)
    if (deviceType == "disable" && tts.contains(" automations")){
    //    gDisable?."${command}"()
        gDisable?.each { a ->
            def aMatch = a.label.toLowerCase()	
            if (tts.contains("${aMatch}") && "$command" == "on") {
                aMatch.on()
                }
            if (tts.contains("${aMatch}") && "$command" == "off") {
            	aMatch.off()
                }
            }
            if (!tts.contains("${aMatch}")) {
            	gDisable?."${command}"()
            if ("$gDisTime" >= 1 && "$command" == "off") { 
        		runIn(gDisTime*60, "automationsRestore")
        		outputTxt = "ok, I will $params.ptts in the $app.label, and they will be automatically restored in $gDisTime minute" + ("$gDisTime" > 1 ? "s" : "")
                return outputTxt
                }
        	if (gDisTime == 0 && "$command" == "off") { 
            	outputTxt = "ok, I will $params.ptts in the $app.label, they will need to be restored manually." 
                }
        	pContCmdsR = "profile"
        	if ("$command" == "on") {
            	unschedule(automationsRestore)
        		outputTxt = "ok, I will $params.ptts in the $app.label"
                }
            }    
        return outputTxt                                  
    	}
     
    // NOTIFICATIONS DISABLE SWITCHES (GROUPS)
    if (deviceType == "disable" && tts.contains("notifications")){
        gNotDisable?."${command}"()
        log.debug "command is: $command, reset time is: $gNotDisTime"
        	if ("$gNotDisTime" >= 1 && "$command" == "off") { 
        		runIn(gNotDisTime*60, "notificationsRestore")
        		outputTxt = "ok, I will $params.ptts in the $app.label, and they will be automatically restored in $gNotDisTime minute" + ("$gNotDisTime" > 1 ? "s" : "")
                return outputTxt
                }
        	if (gNotDisTime == 0 && "$command" == "off") { 
            	outputTxt = "ok, I will $params.ptts in the $app.label, they will need to be restored manually." 
                }
        pContCmdsR = "profile"
        	if ("$command" == "on") {
            	unschedule(notificationsRestore)
        		outputTxt = "ok, I will $params.ptts in the $app.label"
                }
        return outputTxt                                  
    	}

    // INDIVIDUAL AUTOMATIONS CONTROL
    if (tts.contains("automations") && (command == "on" || command == "off")) {  
            gDisable?.each { m -> 
                mMatch = m.label.toLowerCase()
                if(tts.contains("${mMatch}")) {
                    if (command == "on" || command == "off") {
                        m."$command"()
                        outputTxt = "ok, I will $params.ptts"
                        return outputTxt
                    }
                }
            }
        }

    // INDIVIDUAL NOTIFICATIONS CONTROL
    if (tts.contains("notifications") && (command == "on" || command == "off")) { 
            gNotDisable?.each { m -> 
                mMatch = m.label.toLowerCase()
                if(tts.contains("${mMatch}")) {
                    if (command == "on" || command == "off") {
                        m."$command"()
                        outputTxt = "ok, I will $params.ptts"
                        return outputTxt
                    }
                }
            }
        }

	// COLORED LIGHTS - INDIVIDUAL
    if (deviceType == "color") {
        if (gSwitches?.size()>0) {

            gSwitches?.each { c ->
                def cMatch = c.label.toLowerCase()
                if(tts.contains("${cMatch}") && tts.contains("color")) {  // INDIVIDUAL LIGHTS ON/OFF
                    if (parent.trace) log.trace "Individual Color Bulb Match -> $cMatch"
                    def hueSetVals
                    tts = tts.replaceAll("\\b.*color \\b","").replaceAll("\\b.*to \\b","").replace("set lights color to ", "").replace("set the lights to color ", "").replace("set color to ", "")
                    tts = tts.replace("change the color to ", "").replace("change the lights to ", "").replace("change color to ", "").replace("change lights to ", "")
                    tts = tts == "day light" ? "Daylight" : tts == "be light" ? "Daylight" : tts
                    hueSetVals =  getColorName( tts , level)
                    if (hueSetVals) {
                        c?.setColor(hueSetVals)
                        outputTxt =  "Ok, I am setting the $cMatch to the color " + tts
                    }
                    else {
                        outputTxt =  "Sorry, but I wasn't able to change the color to " +  tts
                        def pTryAgain = true
                    	}
                    }
                    return outputTxt
                }
                // COLORED LIGHTS - GROUPS
                if (tts.contains("lights") || tts.contains("color")) {        
                    def hueSetVals
                    tts = tts.replaceAll("\\b.*color \\b","").replaceAll("\\b.*to \\b","")
                    tts = tts == "day light" ? "Daylight" : tts == "be light" ? "Daylight" : tts

                    hueSetVals =  getColorName( tts , level)
                    if (hueSetVals) {
						// FILTER DEVICE FROM DIFFERENT DEVICE TYPES FOR A CAPABILITY
                        gSwitches.each { cl ->
                        def mySwitchCaps = cl.capabilities 
                        mySwitchCaps.commands.each {cap ->
                            if ("$cap.name".contains("setColor")) {
                                outputTxt =  "Ok, changing your bulbs to " + tts
                                cl?.setColor(hueSetVals)
                                log.warn "the color bulb is: $cl"
								//return outputTxt
                        	}
                        }
                    }
                }
            }
        }
        else {
            outputTxt =  "Sorry, I wasn't able to change the color to " +  tts
            def pTryAgain = true
        }
        return outputTxt
    }
    
        if (tts.contains(" fan") && (command == "on" || command == "off")) {  // INDIVIDUAL FANS ON/OFF
            gFans?.each { m -> 
                mMatch = m.label.toLowerCase()
                def lvlNow = m.latestValue("level")
                if(tts.contains("${mMatch}")) {
                    if (command == "on" || command == "off") {
                        m."$command"()
                        outputTxt = "ok, I will $params.ptts"//outputTxt = "I have turned off the $mMatch"
                        return outputTxt
    			}
    		}
    	}
    }
	// INDIVIDUAL AND GROUPS OF LIGHTS, LAMPS, & SWITCHES AS WELL AS ALEXA FEELINGS COMMANDS
    if (deviceType == "light" || deviceType == "light1" || deviceType == "light2" || deviceType == "light3" || deviceType == "light4" ||
    deviceType == "light5" || deviceType == "dimmer" || deviceType == "newLevel") {
    	def deviceG = gSwitches ? gSwitches : gFans ? gFans : gCustom2 ? gCustom2 : "undefined"
		log.debug "The devices selected are $deviceG"
        gSwitches?.each { m ->
            mMatch = m.label.toLowerCase()
            if(tts.contains("${mMatch}") && command != "undefined") {  // INDIVIDUAL LIGHTS ON/OFF
                if (parent.trace) log.trace "Individual Switch Match -> $mMatch"
                if ("$command" == "increase" || "$command" == "decrease") {
                deviceType = dimmer
                } 
                else {
                m."$command"()
                }
                outputTxt = "ok, I will $params.ptts" 
				return outputTxt
            }	// LIGHTS GROUP AND CUSTOM GROUPS
            else if (tts.contains("turn") && command != "undefined" && (tts.contains("lights") || deviceType == "light1" || deviceType == "light2" || deviceType == "light3" || deviceType == "light4" || deviceType == "light5")) {  
                if (deviceType == "light") gSwitches?."$command"()
                if (deviceType == "light1") gCustom1?."$command"() 
                if (deviceType == "light2") gCustom2?."$command"() 
                if (deviceType == "light3") gCustom3?."$command"() 
                if (deviceType == "light4") gCustom4?."$command"() 
                if (deviceType == "light5") gCustom5?."$command"()
                def groupName = deviceType == "light1" ? gCustom1N : deviceType == "light2" ? gCustom2N : deviceType == "light3" ? gCustom3N : deviceType == "light4" ? gCustom4N : deviceType == "light5" ? gCustom5N : "lights"
                outputTxt = "ok, I will $params.ptts"  
                return outputTxt
            }  // INDIVIDUAL DIMMERS SET LEVELS
			else if ((deviceType == "newLevel" || deviceType == "dimmer") && command == "undefined" && tts.findAll("[0-999999]")) {
                if (tts.contains("${mMatch}")) {
                    def level = tts.replaceAll("\\D+","").toInteger();	
                    m.setLevel(level)
                    outputTxt = "ok, I will $params.ptts" 
                    return outputTxt
                }  // DIMMER GROUPS SET LEVELS   
                if (tts.contains("lights") && (deviceType == "newLevel" || deviceType == "dimmer") && command == "undefined" && tts.findAll("[0-999999]")) {
                    def level = tts.replaceAll("\\D+","").toInteger();
                    gSwitches.setLevel(level)
                    outputTxt = "ok, I will $params.ptts"//outputTxt = "I have set the lights to $level percent"
                    return outputTxt
                }
            }  // DIMMER GROUPS ALEXA FEELINGS LEVELS
			else if ((command == "increase" || command == "decrease") && deviceType == "dimmer") {
                gSwitches.each { s ->
                    def	currLevel = s?.latestValue("level")
                    def currState = s?.latestValue("switch") 
                    if (currLevel) {
                        def newLevel = parent.cLevel * 10
                        if (command == "increase") {
                            if (currLevel == null){
                                s?.on()
                                outputTxt = "Ok, turning on the " + app.label + " light"   
                            }
                            else {
                                newLevel =  currLevel + newLevel
                                newLevel = newLevel < 0 ? 0 : newLevel >100 ? 100 : newLevel
                                s?.setLevel(newLevel)
                                outputTxt = "Ok, increasing the " + app.label + " lights to $newLevel percent"
                            }
                        }
                        if (command == "decrease") {
                            if (currLevel == null) {
                                s?.off()
                                outputTxt = "Ok, adjusting off the " + app.label + " lights"                   
                            	return outputTxt
                                }
                            else {
                                newLevel =  currLevel - newLevel
                                newLevel = newLevel < 0 ? 0 : newLevel >100 ? 100 : newLevel
                                s?.setLevel(newLevel)
                                outputTxt = "Ok, decreasing the " + app.label + " lights to $newLevel percent"
                            	return outputTxt
                            }
                        }            
                        if (newLevel > 0 && currState == "off") {
                            s?.on()
                            s?.setLevel(newLevel)
                        }
                        else {                                    
                            if (newLevel == 0 && currState == "on") {
                                s?.off()
                            }
                            else {
                                s?.setLevel(newLevel)
                            }
                        } 
                    }
					else if  (command == "increase" && currState == "off") {s?.on()}
                }
                return outputTxt
            }
        }    
        return outputTxt
    }

    // GROUP FANS  
    if (deviceType == "fan") {
        if (tts.contains("fans") && (command == "on" || command == "off")) {
            gFans."$command"()
            outputTxt = "ok, I will $params.ptts"
            return outputTxt
        }
        if (tts.contains("fan") && (command == "on" || command == "off")) {  // INDIVIDUAL FANS ON/OFF
            gFans?.each { m -> 
                mMatch = m.label.toLowerCase()
                def lvlNow = m.latestValue("level")
                if(tts.contains("${mMatch}")) {
                    if (command == "on" || command == "off") {
                        m."$command"()
                        outputTxt = "ok, I will $params.ptts"//outputTxt = "I have turned off the $mMatch"
                        return outputTxt
                    }
                }
            }
        }

        if ((tts.contains("fan")) && (command == "decrease" || command == "increase" || command == "high" || command == "medium" || command == "low")) {
            def cHigh = parent.cHigh
            def cMedium = parent.cMedium
            def cLow = parent.cLow
            def cFanLevel = parent.cFanLevel
            def newLevel = parent.cLevel
            gFans?.each { m ->
                def fMatch = m.label.toLowerCase()
                if (tts.contains("$fMatch")) {
                    def currLevel = m?.latestValue("level")
                    def currState = m?.latestValue("switch")
                    log.warn "currLevel = $currLevel && currState = $currState"
                    if ((command == "increase" || command == "decrease" || command == "high" || command == "medium" || command == "low") && newLevel == null || currLevel == null) { 
                        outputTxt = "I'm sorry, but the $m does not support the command, $command"
                        return outputTxt 
                    }
                    newLevel = cFanLevel     
                    if (command == "increase") {
                        newLevel =  currLevel + newLevel
                        newLevel = newLevel < 0 ? 0 : newLevel >=100 ? 99 : newLevel
                        m.setLevel(newLevel)
                        outputTxt = "ok, I will $params.ptts"
                    }
                    else if (command == "decrease") {
                        newLevel =  currLevel - newLevel
                        newLevel = newLevel < 0 ? 0 : newLevel >=100 ? 99 : newLevel      
                        m.setLevel(newLevel)
                        outputTxt = "ok, I will $params.ptts" 
                    }
                    else if (command == "high") {
                        newLevel = cHigh
                        m.setLevel(newLevel)
                        outputTxt = "ok, I am setting the $m to high"
                    }
                    else if (command == "medium") {
                        newLevel = cMedium
                        m.setLevel(newLevel)
                        outputTxt = "ok, I am setting the $m to medium"
                    }
                    else if (command == "low") {
                        newLevel = cLow
                        m.setLevel(newLevel)
                        outputTxt = "ok, I am setting the $m to low"
                    }
                    return outputTxt
                }
            }
        }
        return outputTxt
    }                
                            
    // GARAGE DOOR
    if (deviceType == "door") {
        gGarage?.each { m -> 
            mMatch = m.label.toLowerCase()
            if (tts.contains("${mMatch}")) {
                def status = m.currentValue("contact")
                if (command == "open" && status == "closed") {
                    outputTxt = "ok, I will $params.ptts" 
                    m.open()
                } else if (status == "open") {
                    outputTxt = "It looks like the $m is already open"
                } 
                if (command == "close" && status == "open") {
                    outputTxt = "ok, I will $params.ptts" 
                    m.close()
                } else if (status == "closed"){
                    outputTxt = "It looks like the $m is already closed"
                }
            }
        }
        return outputTxt
    }
    
    // INDIVIDUAL VENTS AND SHADES
    if (deviceType == "vent" || deviceType == "shade") {
        gVents?.each { m -> 
            mMatch = m.label.toLowerCase()
            if(tts.contains("${mMatch}")) {
                m."$command"()
                outputTxt = "ok, I will $params.ptts" //outputTxt = "I have turned $command the $mMatch"
                return outputTxt
            }
	    }  
        gShades?.each { m -> 
            mMatch = m.label.toLowerCase()
            if(tts.contains("${mMatch}")) {
                m."$command"()
                outputTxt = "ok, I will $params.ptts" //outputTxt = "I have turned $command the $mMatch"
                return outputTxt
            }
        }  
    }
    // VENTS AND SHADES GROUP CONTROL
    if (deviceType == "vent" || deviceType == "shade") { 
        if (command == "open"  || command == "close") {
            if (command == "open") {
                if(deviceType == "vent"){
                    gVents.on()
                    gVents.setLevel(100)
                    outputTxt = "ok, I will $params.ptts" 
                }
                else {
                    gShades.open()
                    outputTxt = "ok, I will $params.ptts" 
                }
            }
            else {   
                if(deviceType == "vent"){
                    gVents.off()
                    outputTxt = "ok, I will $params.ptts" 
                }
                else {
                    gShades.close()
                    outputTxt = "ok, I will $params.ptts" 
                }
            }  
            return outputTxt
        }
    }

	// VOLUME CONTROLS 
	if (deviceType == "volume") {
        log.info "Volume controls activated"
        if(synth || sSpeaker){
            def deviceD = sSpeaker? sSpeaker : synth? synth : "undefined"
			log.warn "deviceD is: $deviceD"
                def currLevel = deviceD.latestValue("level")
                def currState = deviceD.latestValue("switch")
                def newLevel = parent.cVolLevel//*10  
            if (command == "newVolume" || command == "increase" || command == "decrease" || command == "mute" || command == "unmute" || command == "reset" || command == "create"){
                if (command == "mute" || command == "unmute") {
                    deviceD."${command}"()
                    def volText = command == "mute" ? "muting" : command == "unmute" ? "unmuting" : "adjusting" 
                    outputTxt = "ok, I will $params.ptts" 
                    return outputTxt
                }
                if (command == "reset" && (tts.contains("queue"))) {
        			sSpeaker.resetQueue()
        			pContCmdsR = true
                    outputTxt = "ok, I will $params.ptts"
        			return outputTxt
                    }
				if (command == "increase") {
                    newLevel =  "${currLevel}" + "${newLevel}" 
                    newLevel = "${newLevel}" < 0 ? 0 : "${newLevel}" > 100 ? 100 : "${newLevel}"
                }
                if (command == "decrease") {
                	newLevel =  "${currLevel}" - "${newLevel}"
                    newLevel = newLevel < 0 ? 0 : newLevel > 100 ? 100 : newLevel
                }
                if (command == "newVolume") {
                    newLevel = tts.replaceAll("\\D", "") as double
                        deviceD.setLevel(newLevel)
                }
                if (newLevel > 0 && currState == "off") {
                    deviceD.on()
                    deviceD.setLevel(newLevel)
                }
                else {                                    
                    if (newLevel == 0 && currState == "on") {deviceD.off()}
                    else {deviceD.setLevel(newLevel)}
                }
                outputTxt = "ok, I will $params.ptts to $newLevel" 
                return outputTxt
            } 
        }
    }

    // TASK TRACKER CONTROL
    if (deviceType == "trackerNotification") {
        if (command == "${trackerOne1}".toLowerCase() || command == "${trackerTwo1}".toLowerCase() || command == "${trackerThree1}".toLowerCase() || command == "${trackerFour1}".toLowerCase()) {
            def timeDate = new Date().format("hh:mm aa", location.timeZone)
            def dateDate = new Date().format("EEEE, MMMM d", location.timeZone)
            if (tts.contains("${trackerOne1}".toLowerCase())) {
                if(t1notify) {
                    scheduleHandler1(sched)
                    outputTxt = "Ok, recording that ${app.label}" + " ${trackerOne2}".toLowerCase() + " ${trackerOne3}".toLowerCase() + " ${trackerOne1}".toLowerCase() + " on " + dateDate + " at " + timeDate + ", and I'm scheduling a reminder for " + state.sched  
                }
                else {
                    outputTxt = "Ok, recording that ${app.label} "+ " ${trackerOne2}".toLowerCase() + " ${trackerOne3}".toLowerCase() + " ${trackerOne1}".toLowerCase() + " on " + dateDate + " at " + timeDate  
                }
                if(command == "${trackerOne1}".toLowerCase()) {state.trackerOne = "${app.label} last " + "${trackerOne2} " + "${trackerOne3} " + "${trackerOne1} on " + dateDate + " at " + timeDate }
            }
            else if (tts.contains("${trackerTwo1}".toLowerCase())) {
                if(t2notify) {
                    scheduleHandler2()
                    outputTxt = "Ok, recording that ${app.label}" + " ${trackerOne2}".toLowerCase() + " ${trackerOne3}".toLowerCase() + " ${trackerOne1}".toLowerCase() + " on " + dateDate + " at " + timeDate + ", and I'm scheduling a reminder for " + state.sched  
                }
                else {
                    outputTxt = "Ok, recording that ${app.label} last " + " ${trackerTwo2}".toLowerCase() + " ${trackerTwo3}".toLowerCase() + " ${trackerTwo1}".toLowerCase() + " on " + dateDate + " at " + timeDate
                }
                if(command == "${trackerTwo1}".toLowerCase()) {state.trackerTwo = "${app.label} last " + "${trackerTwo2} " + "${trackerTwo3} " + "${trackerTwo1} on " + dateDate + " at " + timeDate }
            }
            else if (tts.contains("${trackerThree1}".toLowerCase())) {
                if(t3notify) {
                    scheduleHandler3()
                    outputTxt = "Ok, recording that ${app.label}" + " ${trackerOne2}".toLowerCase() + " ${trackerOne3}".toLowerCase() + " ${trackerOne1}".toLowerCase() + " on " + dateDate + " at " + timeDate + ", and I'm scheduling a reminder for " + state.sched  
                }
                else {
                    outputTxt = "Ok, recording that ${app.label} last " + " ${trackerThree2}".toLowerCase() + " ${trackerThree3}".toLowerCase() + "${trackerThree1}".toLowerCase() + " on " + dateDate + " at " + timeDate
                }
                if(command == "${trackerThree1}".toLowerCase()) {state.trackerThree = "${app.label} last " + "${trackerThree2} " + "${trackerThree3} " + "${trackerThree1} on " + dateDate + " at " + timeDate }
            }
            else if (tts.contains("${trackerFour1}".toLowerCase())) {
                if(t4notify) {
                    scheduleHandler4()
                    outputTxt = "Ok, recording that ${app.label}" + " ${trackerOne2}".toLowerCase() + " ${trackerOne3}".toLowerCase() + " ${trackerOne1}".toLowerCase() + " on " + dateDate + " at " + timeDate + ", and I'm scheduling a reminder for " + state.sched  
                }
                else {
                    outputTxt = "Ok, recording that ${app.label} last " + " ${trackerFour2}".toLowerCase() + " ${trackerFour3}".toLowerCase() + "${trackerFour1}".toLowerCase() + " on " + dateDate + " at " + timeDate
                }
                if(command == "${trackerFour1}".toLowerCase()) {state.trackerFour = "${app.label} last " + "${trackerFour2} " + "${trackerFour3} " + "${trackerFour1} on " + dateDate + " at " + timeDate }
            }
            if(psms) { sendtxt(outputTxt) }
            if(pPush) { sendPush outputTxt }
        }
        return outputTxt 
    }   
	return outputTxt
}

def automationsRestore() {
	if (gDisTime != 0) {
    	gDisable?.on()
        if (parent.debug) log.info "Automations have been restored after $gDisTime minutes"
        }
    }

def notificationsRestore() {
    if (gNotDisTime != 0) {
    	gNotDisable?.on()
        if (parent.debug) log.info "Notifications have been restored after $gNotDisTime minutes"
        }
    }
   
/******************************************************************************************************
SPEECH AND TEXT ALEXA RESPONSE
******************************************************************************************************/
/*def runProfile() {
log.info "runProfile activated"
	def tts = state.tts
    tts = tts.toLowerCase()
    def sc = childApps?.find {s -> s?.label?.toLowerCase() == tts?.toLowerCase()}
    log.warn "sc is: $sc.label"
    def message = sc.message
    def result = sc.runProfile(message, evt)
    return result
//    return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
}*/
    

def ttsHandler(tts) {
    state.tts = tts
    log.debug "ttsHandler method has been activated"
    def String outputTxt = (String) null 
    def cm = app.label
    log.debug " ttshandler settings: pAlexaCustResp=${pAlexaCustResp},pAlexaRepeat=${pAlexaRepeat},tts=${tts}"
	
    def sc = childApps?.find {s -> s?.label?.toLowerCase() == tts?.toLowerCase()}
    if (sc) {
    state.sc = "$sc.label"
    log.warn "message = $sc.message"
    sc?.processActions(evt)
        if ((sc.report == true && sc.message != null) && (sc.pistonMsg == false || sc.pistonMsg == null)) {
        	def message = sc.message
            outputTxt = sc.runProfile(message, evt)
            }
        else if (sc.pistonMsg == true) {
        log.info "The piston is producing the audio output"
        }
        else if (sc.scResponse) {
            outputTxt = sc.scResponse
        }
        else {outputTxt = "I'm executing the Logic Block Shortcut for the room, " + cm}
        return outputTxt
    }
    def s1 = childApps.find {s -> s.alias1?.toLowerCase() == tts.toLowerCase()}
    if (s1) {
    	s1.processActions(evt)
        if (s1.report == true && s1.message != null && s1.pistonMsg == false) {
        	def message = s1.message
            outputTxt = s1.runProfile(message, evt) 
            }
        else if (s1.pistonMsg == true) {
        log.info "The piston is producing the audio output"
        }
        else if (s1.scResponse1) {
            outputTxt = s1.scResponse1
        }
        else {outputTxt = "I'm executing the Logic Block Shortcut for the room, " + cm}
        return outputTxt
    }
    def s2 = childApps.find {s -> s.alias2?.toLowerCase() == tts.toLowerCase()}
    if (s2) {
        s2.processActions(evt)
        if (ss2c.report == true && s2.message != null && s2.pistonMsg == false) {
        	def message = s2.message
            outputTxt = s2.runProfile(message, evt) 
            }
        else if (s2.pistonMsg == true) {
        log.info "The piston is producing the audio output"
        }
        else if (s2.scResponse2) {
            outputTxt = s2.scResponse2
        }
        else {outputTxt = "I'm executing the Logic Block Shortcut for the room, " + cm}
        return outputTxt
    }
    def s3 = childApps.find {s -> s.alias3?.toLowerCase() == tts.toLowerCase()}
    if (s3) {
        s3.processActions(evt)
        if (s3.report == true && s3.message != null && s3.pistonMsg == false) {
        	def message = s3.message
            outputTxt = s3.runProfile(message, evt) 
            }
        else if (s3.pistonMsg == true) {
        log.info "The piston is producing the audio output"
        }
        else if (s3.scResponse3) {
            outputTxt = c3.scResponse3
        }
        else {outputTxt = "I'm executing the Logic Block Shortcut for the room, " + cm}
        return outputTxt
    }
    def s4 = childApps.find {s -> s.alias4?.toLowerCase() == tts.toLowerCase()}
    if (s4) {
        s3.processActions(evt)
        if (s4.report == true && s4.message != null && s4.pistonMsg == false) {
        	def message = s4.message
            outputTxt = s4.runProfile(message, evt) 
            }
        else if (s4.pistonMsg == true) {
        log.info "The piston is producing the audio output"
        }
        else if (s4.scResponse3) {
            outputTxt = s4.scResponse4
        }
        else {outputTxt = "I'm executing the Logic Block Shortcut for the room, " + cm}
        return outputTxt
    }
    def s5 = childApps.find {s -> s.alias5?.toLowerCase() == tts.toLowerCase()}
    if (s5) {
        s5.processActions(evt)
        if (s5.report == true && s5.message != null && s5.pistonMsg == false) {
        	def message = s5.message
            outputTxt = s5.runProfile(message, evt) 
            }
        else if (s5.pistonMsg == true) {
        log.info "The piston is producing the audio output"
        }
        else if (s5.scResponse5) {
            outputTxt = s5.scResponse5
        }
        else {outputTxt = "I'm executing the Logic Block Shortcut for the room, " + cm}
        return outputTxt
    }

    //Voice Activation Settings
    def muteAll = tts.contains("disable sound") ? "mute" : tts.contains("disable audio") ? "mute" : tts.contains("mute audio") ? "mute" : tts.contains("silence audio") ? "mute" : null
    muteAll = tts.contains("activate sound") ? "unmute" : tts.contains("enable audio") ? "unmute" : tts.contains("unmute audio") ? "unmute" : muteAll
    def muteAlexa = tts.contains("disable Alexa") ? "mute" : tts.contains("silence Alexa") ? "mute" : tts.contains("mute Alexa") ? "mute" : null
    muteAlexa = tts.contains("enable Alexa") ? "unmute" : tts.contains("start Alexa") ? "unmute" : tts.contains("unmute Alexa") ? "unmute" : muteAll
    def test = tts.contains("this is a test") ? true : tts.contains("a test") ? true : false
    log.debug "Message received from Parent with: (tts) = '${tts}', (intent) = '${intent}', (childName) = '${childName}', current app version: ${release()}"  

    if (test){
        outputTxt = "Salutations and Congratulations! You have successfully completed the installation of EchoSistant" 
        return outputTxt  
    }
    
    if (tts?.contains("do not disturb")) {
        log.info "setting DnD start"
        outputTxt = "ok, I'm turning off all notifications in the $app.label"
        echoDevice.doNotDisturbOff(false)
        log.info "setting DnD"
    }

	if(muteAll == "mute" || muteAll == "unmute"){
        if(muteAll == "mute"){
            state.pMuteAll = true
            outputTxt = "Ok, audio messages have been disabled"       
            return outputTxt
        }
        else { 
            state.pMuteAll = false
            outputTxt = "Ok, audio messages have been enabled"       
            return outputTxt
        }
    }
    if(muteAlexa == "mute" || muteAlexa == "unmute"){
        if(muteAlexa == "mute"){
            state.pMuteAlexa = true
            outputTxt = "Ok, Alexa Feedback Responses have been disabled"       
            return outputTxt
        }
        else { 
            state.pMuteAlexa = false
            outputTxt = "Ok, Alexa Feedback Responses have been enabled"       
            return outputTxt
        }
    }
    
    if (tts.contains("repeat last message") || tts == "repeat the last message" || tts == "repeat last command") {
        outputTxt = "The last message sent to ${app.label} was, " + state.lastMessage
        return outputTxt
    }
    if (tts?.contains("feedback")) {
        if (tts.contains("activate") || tts.contains("start") || tts.contains("enable")) {
            state.pMuteAlexa = true
            outputTxt = "Ok, enabling Alexa feedback. To deactivate just say, deactivate the feedback"
        }
        if (tts.contains("deactivate") || tts.contains("stop") || tts.contains("disable")) {
            state.pMuteAlexa = false
            outputTxt = "Ok, disabling Alexa feedback. To activate just say, activate the feedback"
        }
        return outputTxt
    }
    if (tts?.contains("short answer") || tts?.contains("short answers")) {
        if (tts.contains("activate") || tts.contains("start") || tts.contains("enable")) {
            state.pShort = true
            outputTxt = "Ok, short answers are on."
            return outputTxt
        }        
        else if (tts.contains("deactivate") || tts.contains("stop") || tts.contains("disable")) {
            state.pShort = false
            outputTxt = "Ok, disabling short answers. To activate just say, enable the short answers"
            return outputTxt
        }
    }        
    else {
        ttsActions(tts)
        outputTxt = "Your message has been sent to " + app.label
        return outputTxt     }
    if(parent.debug) log.debug "running actions, sending result to Parent = ${result}"
    return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
}

/******************************************************************************************************
SPEECH AND TEXT ACTION
******************************************************************************************************/
def ttsActions(tts) {
log.info "ttsactions have been called by: $tts"
//    tts = tts
    def msg = tts
    def String ttx = (String) null 	
    def String = tts
	

	//define audio message
    if(pRunMsg){
    	tts = settings.pRunMsg
    }
    else {
        if (pPreMsg) {
            tts = pPreMsg + tts
        }
	}
    //define text message
    if(pRunTextMsg){
        ttx = settings.pRunTextMsg
    }
    else {
        if (pPreTextMsg) {
            ttx = pPreTextMsg + tts
        }
        else {
            ttx = tts
        }
        if(parent.debug) log.debug "defined sms = ${ttx}"
    }
	if (activateAlerts && getDayOk()==true && getModeOk()==true && getTimeOk()==true) {
            if (synthDeviceAlert) {
                synthDeviceAlert?.speak(String) 
                if (parent.debug) log.debug "Sending message to Synthesis Devices"
            }
            if (smcAlert) {
                sendLocationEvent(name: "SmartMessageControl", value: "ESv5 Room: $app.label", isStateChange: true, descriptionText: "${tts}")
                log.info "Message sent to Smart Message Control: Msg = $tts"
                }
            if (echoDeviceAlert) {
            	settings.echoDeviceAlert.each { spk->
                	spk.resetQueue()
                    spk.setVolumeSpeakAndRestore(eVolume, String)
                	}
                }
            if (sonosDeviceAlert){ // 2/22/2017 updated Sono handling when speaker is muted
                def currVolLevel = sonosDeviceAlert.latestValue("level")
                def currMuteOn = sonosDeviceAlert.latestValue("mute").contains("muted")
                if (parent.debug) log.debug "currVolSwitchOff = ${currVolSwitchOff}, vol level = ${currVolLevel}, currMuteOn = ${currMuteOn} "
                if (currMuteOn) { 
                    if (parent.debug) log.warn "speaker is on mute, sending unmute command"
                    sonosDeviceAlert.unmute()
                }
                def sVolumeAlert = settings.volume ?: 20
                sonosDeviceAlert?.playTrackAndResume(state.sound.uri, state.sound.duration, sVolume)
                if (parent.debug) log.info "Playing message on the music player '${sonosDevice}' at volume '${volume}'" 
            	}
            }
    if(state.pMuteAll == false){
        if (getDayOk()==true && getModeOk()==true && getTimeOk()==true) {
            if (synthDevice) {
                synthDevice?.speak(String) 
                if (parent.debug) log.debug "Sending message to Synthesis Devices"
            }
            if (smc) {
                sendLocationEvent(name: "SmartMessageControl", value: "ESv5 Room: $app.label", isStateChange: true, descriptionText: "${tts}")
                log.info "Message sent to Smart Message Control: Msg = $tts"
                }
            if (echoDevice) {
            	settings.echoDevice.each { spk->
                	spk.resetQueue()
                    spk.setVolumeSpeakAndRestore(eVolume, String)
                }
            }     
            if (tts) {
                state.sound = textToSpeech(tts instanceof List ? tts[9] : tts)
            }
            else {
                state.sound = textToSpeech("You selected the custom message option but did not enter a message in the $app.label Smart App")
                if (parent.debug) log.debug "You selected the custom message option but did not enter a message"
            }
            if (sonosDevice){ // 2/22/2017 updated Sono handling when speaker is muted
                def currVolLevel = sonosDevice.latestValue("level")
                def currMuteOn = sonosDevice.latestValue("mute").contains("muted")
                if (parent.debug) log.debug "currVolSwitchOff = ${currVolSwitchOff}, vol level = ${currVolLevel}, currMuteOn = ${currMuteOn} "
                if (currMuteOn) { 
                    if (parent.debug) log.warn "speaker is on mute, sending unmute command"
                    sonosDevice.unmute()
                }
                def sVolume = settings.volume ?: 20
                sonosDevice?.playTrackAndResume(state.sound.uri, state.sound.duration, sVolume)
                if (parent.debug) log.info "Playing message on the music player '${sonosDevice}' at volume '${volume}'" 
            }
        }
        if(recipients || sms){				//if(recipients.size()>0 || sms.size()>0){ removed: 2/18/17 Bobby
            sendtxt(ttx)
        }
    }
    else {
        if(recipients || sms){				//if(recipients.size()>0 || sms.size()>0){ removed: 2/18/17 Bobby
            if (parent.debug) log.debug "Only sending sms because disable voice message is ON"
            sendtxt(ttx)
        }
    }
    if (pVirPer) {
        pVirToggle()
    }
    if (shmState) {
        shmStateChange()
    }    
    if (sHues) {               
        processColor()
    }
    if (sFlash) {
        flashLights()
    }
    profileDeviceControl()
    if (pRoutine) {
        location.helloHome?.execute(settings.pRoutine)
    }
    if (pRoutine2) {
        location.helloHome?.execute(settings.pRoutine2)
    }
    if (pMode) {
        setLocationMode(pMode)
    }
    if (push && pPreTextMsg) {
        tts = pPreTextMsg + tts
        sendPushMessage(tts)
    }
    else if (push) {
        sendPushMessage(tts)
    }
    def stamp = new Date(now()).format("h:mm aa", location.timeZone)
    state.lastMessage = tts + ", and it was sent at " + stamp 
    return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]
}

/***********************************************************************************************************************
RESTRICTIONS HANDLER
***********************************************************************************************************************/
private getAllOk() {
    modeOk && daysOk && timeOk
}
private getModeOk() {
    def result = !modes || modes?.contains(location.mode)
    if(parent.debug) log.debug "modeOk = $result"
    result
} 
private getDayOk() {
    def result = true
    if (day) {
        def df = new java.text.SimpleDateFormat("EEEE")
        if (location.timeZone) {
            df.setTimeZone(location.timeZone)
        }
        else {
            df.setTimeZone(TimeZone.getTimeZone("America/New_York"))
        }
        def day = df.format(new Date())
        result = day.contains(day)
    }
    if(parent.debug) log.debug "daysOk = $result"
    result
}
private getTimeOk() {
    def result = true
    if ((starting && ending) ||
        (starting && endingX in ["Sunrise", "Sunset"]) ||
        (startingX in ["Sunrise", "Sunset"] && ending) ||
        (startingX in ["Sunrise", "Sunset"] && endingX in ["Sunrise", "Sunset"])) {
        def currTime = now()
        def start = null
        def stop = null
        def s = getSunriseAndSunset(zipCode: zipCode, sunriseOffset: startSunriseOffset, sunsetOffset: startSunsetOffset)
        if(startingX == "Sunrise") start = s.sunrise.time
        else if(startingX == "Sunset") start = s.sunset.time
            else if(starting) start = timeToday(starting,location.timeZone).time
                s = getSunriseAndSunset(zipCode: zipCode, sunriseOffset: endSunriseOffset, sunsetOffset: endSunsetOffset)
            if(endingX == "Sunrise") stop = s.sunrise.time
            else if(endingX == "Sunset") stop = s.sunset.time
                else if(ending) stop = timeToday(ending,location.timeZone).time
                    result = start < stop ? currTime >= start && currTime <= stop : currTime <= stop || currTime >= start
            if (parent.debug) log.trace "getTimeOk = $result."
            }
    return result
}
private hhmm(time, fmt = "h:mm a") {
    def t = timeToday(time, location.timeZone)
    def f = new java.text.SimpleDateFormat(fmt)
    f.setTimeZone(location.timeZone ?: timeZone(time))
    f.format(t)
}
private offset(value) {
    def result = value ? ((value > 0 ? "+" : "") + value + " min") : ""
}
private timeIntervalLabel() {
    def result = "complete"
    if      (startingX == "Sunrise" && endingX == "Sunrise") result = "Sunrise" + offset(startSunriseOffset) + " to Sunrise" + offset(endSunriseOffset)
    else if (startingX == "Sunrise" && endingX == "Sunset") result = "Sunrise" + offset(startSunriseOffset) + " to Sunset" + offset(endSunsetOffset)
        else if (startingX == "Sunset" && endingX == "Sunrise") result = "Sunset" + offset(startSunsetOffset) + " to Sunrise" + offset(endSunriseOffset)
            else if (startingX == "Sunset" && endingX == "Sunset") result = "Sunset" + offset(startSunsetOffset) + " to Sunset" + offset(endSunsetOffset)
                else if (startingX == "Sunrise" && ending) result = "Sunrise" + offset(startSunriseOffset) + " to " + hhmm(ending, "h:mm a z")
                    else if (startingX == "Sunset" && ending) result = "Sunset" + offset(startSunsetOffset) + " to " + hhmm(ending, "h:mm a z")
                        else if (starting && endingX == "Sunrise") result = hhmm(starting) + " to Sunrise" + offset(endSunriseOffset)
                            else if (starting && endingX == "Sunset") result = hhmm(starting) + " to Sunset" + offset(endSunsetOffset)
                                else if (starting && ending) result = hhmm(starting) + " to " + hhmm(ending, "h:mm a z")
                                    }

/***********************************************************************************************************************
	ALERT RESTRICTIONS HANDLER
***********************************************************************************************************************/
private getAllAlertsOk() {
    alertModeOk && alertDaysOk && alertTimeOk && alertSwitchesOk
}
private getAlertSwitchesOk() {
	def result = false
	def devList = []
    if (alertSwitch == null) { result = true }
    if (alertSwitch) {
    if (parent.trace) log.trace "Conditions: Switches events method activated"
        def alertSwitchSize = alertSwitch?.size()
        alertSwitch.each { deviceName ->
            def status = deviceName.currentValue("switch")
            if (status == "${alertSwitchCmd}"){ 
                String device  = (String) deviceName
                devList += device
            }
        }
        def devListSize = devList?.size()
        if(!alertSwitchAll) {
            if (devList?.size() > 0) { 
                result = true 
                if(parent.debug) log.debug "alertSwitchesOk = $result"
            }
            result
        }        
        if(alertSwitchAll) {
            if (devList?.size() == alertSwitch?.size()) { 
                result = true
                if(parent.debug) log.debug "alertSwitchesOk = $result"
            }
            result
        }
        if (result == false) log.debug "alertSwitchesOk = $result"
    }
    result
}

private getAlertModeOk() {
    def result = !alertMode || alertMode?.contains(location.mode)
//    if (alertModeOk != null) { if(parent.debug) log.debug "alertModeOk = $result" }
    result
} 
private getAlertDaysOk() {
    def result = true
    if (alertDays) {
        def df = new java.text.SimpleDateFormat("EEEE")
        if (location.timeZone) {
            df.setTimeZone(location.timeZone)
        }
        else {
            df.setTimeZone(TimeZone.getTimeZone("America/New_York"))
        }
        def day = df.format(new Date())
        result = day.contains(alertDays)
    }
//    if(parent.debug) log.debug "alertDaysOk = $result"
    result
}
        
private getAlertTimeOk() {
    def result = true
    if ((startingA && endingA) ||
        (startingA && endingXA in ["Sunrise", "Sunset"]) ||
        (startingXA in ["Sunrise", "Sunset"] && endingA) ||
        (startingXA in ["Sunrise", "Sunset"] && endingXA in ["Sunrise", "Sunset"])) {
        def currTime = now()
        def start = null
        def stop = null
        def s = getSunriseAndSunset(zipCode: zipCode, sunriseOffset: startSunriseOffset, sunsetOffset: startSunsetOffset)
        if(startingXA == "Sunrise") start = s.sunrise.time
        else if(startingXA == "Sunset") start = s.sunset.time
            else if(startingA) start = timeToday(startingA,location.timeZone).time
                s = getSunriseAndSunset(zipCode: zipCode, sunriseOffset: endSunriseOffset, sunsetOffset: endSunsetOffset)
            if(endingXA == "Sunrise") stop = s.sunrise.time
            else if(endingXA == "Sunset") stop = s.sunset.time
                else if(endingA) stop = timeToday(endingA,location.timeZone).time
                    result = start < stop ? currTime >= start && currTime <= stop : currTime <= stop || currTime >= start
            if (parent.debug) log.trace "getAlertTimeOk = $result."
            }
    return result
}
private hhmmAlert(time, fmt = "h:mm a") {
    def t = timeToday(time, location.timeZone)
    def f = new java.text.SimpleDateFormat(fmt)
    f.setTimeZone(location.timeZone ?: timeZone(time))
    f.format(t)
}
private offsetAlert(value) {
    def result = value ? ((value > 0 ? "+" : "") + value + " min") : ""
}
private timeIntervalLabelAlert() {
    def result = "complete"
    if      (startingXA == "Sunrise" && endingXA == "Sunrise") result = "Sunrise" + offsetA(startSunriseOffset) + " to Sunrise" + offsetA(endSunriseOffset)
    else if (startingXA == "Sunrise" && endingXA == "Sunset") result = "Sunrise" + offsetA(startSunriseOffset) + " to Sunset" + offsetA(endSunsetOffset)
        else if (startingXA == "Sunset" && endingXA == "Sunrise") result = "Sunset" + offsetA(startSunsetOffset) + " to Sunrise" + offsetA(endSunriseOffset)
            else if (startingXA == "Sunset" && endingXA == "Sunset") result = "Sunset" + offsetA(startSunsetOffset) + " to Sunset" + offsetA(endSunsetOffset)
                else if (startingXA == "Sunrise" && endingA) result = "Sunrise" + offsetA(startSunriseOffset) + " to " + hhmmAlert(ending, "h:mm a z")
                    else if (startingXA == "Sunset" && ending) result = "Sunset" + offsetA(startSunsetOffset) + " to " + hhmmAlert(ending, "h:mm a z")
                        else if (startingA && endingXA == "Sunrise") result = hhmmAlert(startingA) + " to Sunrise" + offsetA(endSunriseOffset)
                            else if (startingA && endingXA == "Sunset") result = hhmm(startingA) + " to Sunset" + offsetA(endSunsetOffset)
                                else if (startingA && endingA) result = hhmmAlert(starting) + " to " + hhmmSlert(ending, "h:mm a z")
                                    }

/***********************************************************************************************************************
SMS HANDLER
***********************************************************************************************************************/
private void sendtxt(message) {
        if (parent.debug) log.debug "Request to send sms received with message: '${message}'"
    if (sendContactText) { 
        sendNotificationToContacts(message, recipients)
        if (parent.debug) log.debug "Sending sms to selected reipients"
    } 
    else {
        if (push || shmNotification) { 
            sendPushMessage
            if (parent.debug) log.debug "Sending push message to mobile app"
        }
    }
    if (alertTxt) {
    	sendAlertMsg(message) 
        }
    if (notify) {
        sendNotificationEvent(message)
        if (parent.debug) log.debug "Sending notification to mobile app"

    }
    if (notifyGdoorOpen) {
        if (message.contains("open")) {
            sendTextGarage(message)
        }
    }
    if (notifyGdoorClose) {
        if (message.contains("close")) {
            sendTextGarage(message)
        }
    }
    if (notifyVPArrive) {
        if (message.contains("check") && message.contains("in")) {
            sendTextvp(message)
            if (vpNotification) {
                sendPush(message)
            }
        }
    }
    if (notifyVPDepart) {
        if (message.contains("check") && message.contains("out")) {
            sendTextvp(message)
            if (vpNotification) {
                sendPush(message)
            }
        }
    }    
    if (notifySHMArm) {
        if (message.contains("Stay") || message.contains("Away")) {
            sendTextshm(sms, message)
        }
    }
    if (notifySHMDisarm) {
        if (message.contains("Disarm")) {
            sendTextshm(sms, message)
        }
    }    
    if (sms) {
        sendText(sms, message)
        if (parent.debug) log.debug "Processing message for selected phones"
    }
    if (psms) {
        processpsms(psms, message)
    }
}
private void sendTextvp(message) { 
    if (vpPhone != null) {
        def vpPhones = vpPhone.split("\\,")
        for (phone in vpPhones) {
            sendSms(vpPhone, message)
        }
    }
}
private void sendAlertMsg(message) {
    if (alertPhone != null) {
        def alertPhones = alertPhone.split("\\,")
        for (phone in alertPhones) {
            sendSms(alertPhone, message)
        }
    }
}

private void sendTextGarage(message) {
    if (garagePhone != null) {
        def garagePhones = garagePhone.split("\\,")
        for (phone in garagePhones) {
            sendSms(garagePhone, message)
        }
    }
}
private void sendTextshm(number, message) {
    if (shmPhone != null) {
        def shmPhones = shmPhone.split("\\,")
        for (phone in shmPhones) {
            sendSms(shmPhone, message)
        }
    }
} 
private void sendText(number, message) {
    if (sms) {
        def phones = sms.split("\\,")
        for (phone in phones) {
            sendSms(phone, message)
            if (parent.debug) log.debug "Sending sms to selected phones"
        }
    }
}
private void processpsms(psms, message) {
    if (psms) {
        def phones = psms.split("\\,")
        for (phone in phones) {
            sendSms(phone, message)
        }
    }
}

/************************************************************************************************************
Switch/Color/Dimmer/Toggle Handlers
************************************************************************************************************/
// Used for delayed devices
def turnOnSwitch() { sSwitches?.on() }  
def turnOffSwitch() { sSwitches?.off() }
def turnOnOtherSwitch() { sOtherSwitch?.on() }
def turnOffOtherSwitch() { sOtherSwitch?.off() }  
def turnOnDimmers() { def level = dimmersLVL < 0 || !dimmersLVL ?  0 : dimmersLVL >100 ? 100 : dimmersLVL as int
    sDimmers?.setLevel(sDimmersLVL) }
def turnOffDimmers() { sDimmers?.off() }
def turnOnOtherDimmers() { def otherlevel = otherDimmersLVL < 0 || !otherDimmersLVL ?  0 : otherDimmersLVL >100 ? 100 : otherDimmersLVL as int
    sOtherDimmers?.setLevel(sOtherDimmersLVL) }
def turnOffOtherDimmers() { sOtherDimmers?.off() }   

// Primary control of profile triggered lights/switches when delayed handler
def profileDeviceControl() {
    if (sSecondsOn) { runIn(sSecondsOn,turnOnSwitch)}
    if (sSecondsOff) { runIn(sSecondsOff,turnOffSwitch)}
    if (sOtherSecondsOn)  { runIn(sOtherSecondsOn,turnOnOtherSwitch)}
    if (sOtherSecondsOff) { runIn(sOtherSecondsOff,turnOffOtherSwitch)}
    if (sSecondsDimmers) { runIn(sSecondsDimmers,turnOnDimmers)}
    if (sSecondsDimmersOff) { runIn(sSecondsDimmersOff,turnOffDimmers)}
    if (sSecondsOtherDimmers) { runIn(sSecondsOtherDimmers,turnOnOtherDimmers)}
    if (sSecondsOtherDimmersOff) { runIn(sSecondsOtherDimmersOff,turnOffOtherDimmers)}
    if (sDimmersCmd == "set" && sDimmers) { def level = sDimmersLVL < 0 || !sDimmersLVL ?  0 : sDimmersLVL >100 ? 100 : sDimmersLVL as int
        sDimmers?.setLevel(level) }

// Control of Lights and Switches when not delayed handler         
    if (!sSecondsOn) {
        if  (sSwitchCmd == "on") { sSwitches?.on() }
        else if (sSwitchCmd == "off") { sSwitches?.off() }
        if (sSwitchCmd == "toggle") { toggle() }
        if (sOtherSwitchCmd == "on") { sOtherSwitch?.on() }
        else if (sOtherSwitchCmd == "off") { sOtherSwitch?.off() }
        if (otherSwitchCmd == "toggle") { toggle() }

        if (sOtherDimmersCmd == "set" && sOtherDimmers) { def otherLevel = sOtherDimmersLVL < 0 || !sOtherDimmersLVL ?  0 : sOtherDimmersLVL >100 ? 100 : sOtherDimmersLVL as int
            sOtherDimmers?.setLevel(otherLevel) }
    }
}

// SWITCHES TOGGLE HANDLER
private toggle() {
    sSwitches.each { deviceName ->
        def switchattr = deviceName.currentSwitch
        if (switchattr.contains('on')) {
            deviceName.off()
        }
        else {
            deviceName.on()
        }
    }
    sOtherSwitch.each { deviceName ->
        def switchattr = deviceName.currentSwitch
        if (switchattr.contains('on')) {
            deviceName.off()
        }
        else {
            deviceName.on()
        }
    }		
}


/************************************************************************************************************
Flashing Lights Handler
************************************************************************************************************/
private flashLights() {
    if (parent.debug) log.debug "The Flash Switches Option has been activated"
    def doFlash = true
    def onFor = onFor ?: 60000/60
    def offFor = offFor ?: 60000/60
    def numFlashes = numFlashes ?: 3

    if (state.lastActivated) {
        def elapsed = now() - state.lastActivated
        def sequenceTime = (numFlashes + 1) * (onFor + offFor)
        doFlash = elapsed > sequenceTime
    }
    if (doFlash) {
        state.lastActivated = now()
        def initialActionOn = sFlash.collect{it.currentflashSwitch != "on"}
        def delay = 0L

        numFlashes.times {
            sFlash.eachWithIndex {s, i ->
                if (initialActionOn[i]) {
                    s.on(delay: delay)
                }
                else {
                    s.off(delay:delay)                   
                } 
            }
            delay += onFor
            sFlash.eachWithIndex {s, i ->
                if (initialActionOn[i]) {
                    s.off(delay: delay)
                }
                else {
                    s.on(delay:delay)
                }
            }
            delay += offFor
        }
    }
} 
        
/******************************************************************************************************
CUSTOM COMMANDS - CONTROL
******************************************************************************************************/
private getCommand(tts){
	log.info "getCommand method activated with this tts: $tts "
    def String command = (String) null
    def String deviceType = (String) null
    tts = tts.toLowerCase()

	    if (tts == "reset the q") {
    	tts = "reset the queue"
        command = "reset"
        deviceType = "volume"
        }

//log.warn "tts has been changed to: $tts"
//LIGHT SWITCHES & CUSTOM GROUPS
    if (gHues || gSwitches || gCustom1N || gCustom2N || gCustom3N || gCustom4N || gCustom5N){
        if (gSwitches) {
            if (tts.contains("set the ") && !tts.contains(" volume") && !tts.contains(" color")) {  // DIMMERS, DIMMER GROUPS
        	command = "undefined"
            deviceType = "newLevel"
            }
            else {
            command = tts.contains("turn on") ? "on" : tts.contains("turn off") ? "off" : tts.contains("switch on") ? "on" : tts.contains("lights on") ? "on" : tts.contains("lights off") ? "off" : tts.contains("switch off") ? "off" : "undefined"
            if (command == "undefined") {
               	command = tts.contains("darker") ? "decrease" : tts.contains("decrease") ? "decrease" : tts.contains("dim ") ? "decrease" : tts.contains("dimmer") ? "decrease" : tts.contains("lower") ? "decrease" :"undefined"
            	}
            if (command == "undefined") {
                command = tts.contains("raise") ? "increase" : tts.contains("brighter")  ? "increase" : tts.contains("increase") ? "increase" : tts.contains("brighten") ? "increase" : "undefined"
            	}
			log.warn "command = $command"
            deviceType = "light"
        	}
        } 
        if (gCustom1N) {
        	if (tts.contains(settings.gCustom1N.toLowerCase())) {
            command = tts.contains("turn on") ? "on" : tts.contains("turn off") ? "off" : tts.contains("switch on") ? "on" : tts.contains("lights on") ? "on" : tts.contains("lights off") ? "off" : tts.contains("switch off") ? "off" : "undefined"
            if (command == "undefined") {
               	command = tts.contains("darker") ? "decrease" : tts.contains("decrease") ? "decrease" : tts.contains("dim") ? "decrease" : tts.contains("dimmer") ? "decrease" : tts.contains("lower") ? "decrease" :"undefined"
            	}
            if (command == "undefined") {
                command = tts.contains("raise") ? "increase" : tts.contains("brighter")  ? "increase" : tts.contains("increase") ? "increase" : tts.contains("brighten") ? "increase" : "undefined"
            	}
            log.warn "command = $command"
            deviceType = "light1"
        	}
        }    
        if (gCustom2N) {
            if (tts.contains(settings.gCustom2N.toLowerCase())) {
                command = tts.contains("turn on") ? "on" : tts.contains("turn off") ? "off" : tts.contains("switch on") ? "on" : tts.contains("lights on") ? "on" : tts.contains("lights off") ? "off" : tts.contains("switch off") ? "off" : "undefined"
            if (command == "undefined") {
               	command = tts.contains("darker") ? "decrease" : tts.contains("decrease") ? "decrease" : tts.contains("dim") ? "decrease" : tts.contains("dimmer") ? "decrease" : tts.contains("lower") ? "decrease" :"undefined"
            	}
            if (command == "undefined") {
                command = tts.contains("raise") ? "increase" : tts.contains("brighter")  ? "increase" : tts.contains("increase") ? "increase" : tts.contains("brighten") ? "increase" : "undefined"
            	}
                deviceType = "light2"
            }
        }
        if (gCustom3N) {
            if (tts.contains(settings.gCustom3N.toLowerCase())) {
                command = tts.contains("turn on") ? "on" : tts.contains("turn off") ? "off" : tts.contains("switch on") ? "on" : tts.contains("lights on") ? "on" : tts.contains("lights off") ? "off" : tts.contains("switch off") ? "off" : "undefined"
            if (command == "undefined") {
               	command = tts.contains("darker") ? "decrease" : tts.contains("decrease") ? "decrease" : tts.contains("dim") ? "decrease" : tts.contains("dimmer") ? "decrease" : tts.contains("lower") ? "decrease" :"undefined"
            	}
            if (command == "undefined") {
                command = tts.contains("raise") ? "increase" : tts.contains("brighter")  ? "increase" : tts.contains("increase") ? "increase" : tts.contains("brighten") ? "increase" : "undefined"
            	}
                deviceType = "light3"
            }
        }
        if (gCustom4N) {
            if (tts.contains(settings.gCustom4N.toLowerCase())) {
                command = tts.contains("turn on") ? "on" : tts.contains("turn off") ? "off" : tts.contains("switch on") ? "on" : tts.contains("lights on") ? "on" : tts.contains("lights off") ? "off" : tts.contains("switch off") ? "off" : "undefined"
            if (command == "undefined") {
               	command = tts.contains("darker") ? "decrease" : tts.contains("decrease") ? "decrease" : tts.contains("dim") ? "decrease" : tts.contains("dimmer") ? "decrease" : tts.contains("lower") ? "decrease" :"undefined"
            	}
            if (command == "undefined") {
                command = tts.contains("raise") ? "increase" : tts.contains("brighter")  ? "increase" : tts.contains("increase") ? "increase" : tts.contains("brighten") ? "increase" : "undefined"
            	}
                deviceType = "light4"
            }
        }
        if (gCustom5N) {
            if (tts.contains(settings.gCustom5N.toLowerCase())) {
                command = tts.contains("turn on") ? "on" : tts.contains("turn off") ? "off" : tts.contains("switch on") ? "on" : tts.contains("lights on") ? "on" : tts.contains("lights off") ? "off" : tts.contains("switch off") ? "off" : "undefined"
            if (command == "undefined") {
               	command = tts.contains("darker") ? "decrease" : tts.contains("decrease") ? "decrease" : tts.contains("dim") ? "decrease" : tts.contains("dimmer") ? "decrease" : tts.contains("lower") ? "decrease" :"undefined"
            	}
            if (command == "undefined") {
                command = tts.contains("raise") ? "increase" : tts.contains("brighter")  ? "increase" : tts.contains("increase") ? "increase" : tts.contains("brighten") ? "increase" : "undefined"
            	}
                deviceType = "light5"
            }
        }        
    }      

//case "Dimmer Commands":
        if (!tts.contains("volume") && (tts.contains("decrease") ||tts.contains("darker") || tts.contains("too bright") || tts.contains("dim") || tts.contains("dimmer") || tts.contains("turn down"))) {
            command = "decrease" 
            deviceType = "dimmer"
        }
        else if (!tts.contains("volume") && (tts.contains("increase") || tts.contains("not bright enough") || tts.contains("brighter") || tts.contains("too dark") || tts.contains("turn up") ||tts.contains("brighten"))) {
            command = "increase" 
            deviceType = "dimmer"
        }    
        else if (tts.startsWith("set the") && !tts.contains("volume") && !tts.contains("color")) {  // DIMMERS, DIMMER GROUPS
        	command = "undefined"
            deviceType = "newLevel"
        }
        else if (tts.contains("reset the queue") || tts.contains("reset the q ")) { // RESETS THE QUEUE FOR ALEXA DEVICES
        	command = "reset"
            deviceType = "volume"
        }
        else if (tts.contains("color")) {  // COLOR CHANGING BULBS
        	command = "colorChange"
            deviceType = "color"
        }    
        else if (tts.startsWith("set the volume")) {  // volume control for speakers & harmony
        	command = "newVolume"
            deviceType = "volume"
        }
        else if (tts.contains("increase") && tts.contains("volume")) {  // volume control for speakers & harmony
        	command = "increase"
            deviceType = "volume"
        }
        else if (tts.contains("decrease") && tts.contains("volume")) {  // volume control for speakers & harmony
        	command = "decrease"
            deviceType = "volume" 
        }

    //Virtual Presence Check In/Out
    if (tts?.contains ("checking in") || tts?.contains ("checking out")) {
        deviceType = "virPres" 
        command = "checking" 
    }
    
    //Disable Switches
    if (tts=="stop the automations" || tts=="stop the notifications" || tts?.startsWith("cut off") || tts?.startsWith("disengage") || tts?.startsWith("disable automation") || tts?.startsWith("stop turning the") || tts?.startsWith("kill the automation") || tts?.contains("kill the sensor")){
        command = "off"
        deviceType = "disable"
    }
    else if (tts=="start the automations" || tts=="start the notifications" || tts?.startsWith("cut on") || tts?.startsWith("engage") || tts?.startsWith("start turning the") || tts?.startsWith ("start the sensor")){
        command = "on"
        deviceType = "disable" 
    }
    
    // Fans
    if (tts.startsWith("set the fan") || tts.contains("set the fans") || tts.contains("fans") || tts.contains("set the speed") || tts.contains("fan") || tts.contains("cold") || tts.contains("hot")) {
        if (tts.contains(" on ") || tts.contains("start")) {
            command = "on" 
            deviceType = "fan"
        }
        else if (tts.contains(" off ") || tts.contains("stop")) {
            command = "off" 
            deviceType = "fan"
        }
        else if (tts.contains("high") || tts.contains("medium") || tts.contains("low")) {
            command = tts?.contains("high") ? "high" : tts?.contains("medium") ? "medium" : tts?.contains("low") ? "low" : "undefined"
            deviceType = "fan"
        }
        else if  (tts.contains("slow down") || tts.contains("too fast" ) || tts.contains("turn down") || tts.contains("decrease") || tts.contains("too cold") || tts.contains("it's cold") || tts.contains("cold")) {
            command = "decrease"
            deviceType = "fan" 
        }
        else if  (tts.contains("speed up") || tts.contains("too slow") || tts.contains("turn up") || tts.contains("increase") || tts.contains("too hot") || tts.contains("it's hot") || tts.contains("hot")) {
            command = "increase"
            deviceType = "fan" 
        }

        else {
            command = "undefined"
            deviceType = "fan" 
        }      
    }

    // Vents
    if (tts?.contains("vent")) {  
        if (text.contains("open")) {
            command = "on" 
            deviceType = "vent"
        }
        if (tts.contains("close")) {
            command = "off" 
            deviceType = "vent" 
        }
    }
    
    // Doors
    if (tts?.contains("door")) {
        if (tts.contains("open")) {
            command = "open" 
            deviceType = "door"
        }
        else if (tts.contains("close")) {
            command = "close" 
            deviceType = "door" 
        }
//        else {
//            command = "undefined"
//            deviceType = "door"
//        }
    }    

    // Locks
    if (tts?.contains("lock")) {
        if (tts.contains("unlocked")) {
            command = "unlocked" 
            deviceType = "locks"
        }
        if (tts.contains("locked")) {
            command = "locked" 
            deviceType = "locks"  
        }
    }    
    
    // Shades
    if (tts?.contains("shade") || tts?.contains("blinds") || tts?.contains("curtains") ) {  
        if (tts.contains("open")) {
            command = "open" 
            deviceType = "shade"
        }
        else if (tts.contains("closed")) {
            command = "closed"
            deviceType = "shade"
        }    
        else if (tts.contains("close")) {
            command = "close" 
            deviceType = "shade"
        }
    } 
    
    //Harmony
    if (tts?.contains("tv")) {
        if  (tts.contains("start") || tts.startsWith("turn on") || tts.contains("switch to") || tts.contains("on")){
            command = "startActivity"
            deviceType = "tv"
            log.info "Harmony start activity control"
        }
        else if  (tts.contains("stop") || tts.startsWith("turn off") || tts.contains("switch off") || tts.contains("off")){
            command = "activityoff"
            deviceType = "tv"
        }
        else { 
            command = "undefined"
            deviceType = "tv"
            log.info "Harmony stop activity control"
        }
    }

//Task Tracker
    if (tts?.startsWith("The".toLowerCase()) || tts?.startsWith("She".toLowerCase()) || tts?.startsWith("He".toLowerCase()) || tts?.startsWith("It".toLowerCase()) || tts?.startsWith("I".toLowerCase())) {
        if (tts?.contains("${trackerOne1}".toLowerCase()) || tts.contains("$trackerTwo1".toLowerCase()) || tts?.contains("$trackerThree1".toLowerCase()) || tts?.contains("$trackerFour1".toLowerCase())) {
            command = tts?.contains("${trackerOne1}".toLowerCase()) ? "${trackerOne1}".toLowerCase() : tts?.contains("${trackerTwo1}".toLowerCase()) ? "${trackerTwo1}".toLowerCase() : tts?.contains("${trackerThree1}".toLowerCase()) ? "${trackerThree1}".toLowerCase() : tts?.contains("${trackerFour1}".toLowerCase()) ? "${trackerFour1}".toLowerCase() : "undefined"
            deviceType = "trackerNotification"
            log.info "Task Tracker activated"
        }
	}
    if (command == "undefined") {
    	if (deviceType != "light" && deviceType != "light1" && deviceType != "light1" && deviceType != "light1" && deviceType != "light1" && deviceType != "light1" &&
        deviceType != "trackerNotification" && deviceType != "tv" && deviceType != "dimmer" && deviceType != "newLevel" && deviceType != "volume" && deviceType != "virPres" && deviceType != "disable" &&
        deviceType != "fan" && deviceType != "vent" &&  deviceType != "door" && deviceType != "locks" && deviceType != "shade") {
    	deviceType = "message"
        }
	}
    return ["deviceType":deviceType, "command":command ]
}

/************************************************************************************************************
Custom Color Filter
************************************************************************************************************/       
def profileLoop(child) {
    def childName = app.label
    def result
    if(childName == child){
        if(gHues){
            int hueLevel = !level ? 100 : level
            int hueHue = Math.random() *100 as Integer
            def randomColor = [hue: hueHue, saturation: 100, level: hueLevel]
            gHues.setColor(randomColor)
            runIn(60, "startLoop")
            result =  "Ok, turning the color loop on, in the " + childName

        }
        else result = "Sorry, I wasn't able to turn the color loop on in the " + childName
    }
    return result
}
private startLoop() {
    def device =  state.lastDevice
    def deviceMatch = cSwitch.find {s -> s.label.toLowerCase() == device.toLowerCase()}	
    int hueLevel = !level ? 100 : level
    int hueHue = Math.random() *100 as Integer
    def randomColor = [hue: hueHue, saturation: 100, level: hueLevel]
    gHues.setColor(randomColor)
    runIn(60, "continueLoop")
}


private continueLoop() {
    int hueLevel = !level ? 100 : level
    int hueHue = Math.random() *100 as Integer
    def randomColor = [hue: hueHue, saturation: 100, level: hueLevel]
    gHues.setColor(randomColor)
    runIn(60, "startLoop")
}
def profileLoopCancel(child) {
    def childName = app.label 
    def result
    if(childName == child){
        unschedule("startLoop")
        unschedule("continueLoop")
        result =  "Ok, turning the color loop off in the " + childName
    }
    else result = "Sorry, I wasn't able to turn the color loop off"
    return result
}
private setRandomColorName(){
    for (bulb in gHues) {    
        int hueLevel = !level ? 100 : level
        int hueHue = Math.random() *100 as Integer
        def randomColor = [hue: hueHue, saturation: 100, level: hueLevel]
        bulb.setColor(randomColor)
    }
}
private processColor() {
    if (sHuesCmd == "on") { sHues?.on() }
    if (sHuesCmd == "off") { sHues?.off() }
    if (sHuesOtherCmd == "on") { sHuesOther?.on() }
    if (sHuesOtherCmd == "off") { sHuesOther?.off() }
    def hueSetVals = getColorName("${sHuesColor}",level)
    	sHues?.setColor(hueSetVals)
    def	hueSetValsOther = getColorName("${sHuesOtherColor}",level)
    	sHuesOther?.setColor(hueSetValsOther)
}
private getColorName(sHuesColor, level) {
    for (color in fillColorSettings()) {
		if (color.name.toLowerCase() == sHuesColor.toLowerCase()) {
        log.warn "found a color match"
        	int hueVal = Math.round(color.h / 3.6)
            int hueLevel = !level ? color.l : level
			def hueSet = [hue: hueVal, saturation: color.s, level: hueLevel]
            return hueSet
		}
	}
}

def fillColorSettings() {
    return [
        [ name: "Soft White",				rgb: "#B6DA7C",		h: 83,		s: 44,		l: 67,	],
        [ name: "Warm White",				rgb: "#DAF17E",		h: 51,		s: 20,		l: 100,	],
        [ name: "Very Warm White",			rgb: "#DAF17E",		h: 51,		s: 60,		l: 51,	],
        [ name: "Daylight White",			rgb: "#CEF4FD",		h: 191,		s: 9,		l: 90,	],
        [ name: "Daylight",					rgb: "#CEF4FD",		h: 191,		s: 9,		l: 90,	],        
        [ name: "Cool White",				rgb: "#F3F6F7",		h: 187,		s: 19,		l: 96,	],
        [ name: "White",					rgb: "#FFFFFF",		h: 0,		s: 0,		l: 100,	],
        [ name: "Alice Blue",				rgb: "#F0F8FF",		h: 208,		s: 100,		l: 97,	],
        [ name: "Antique White",			rgb: "#FAEBD7",		h: 34,		s: 78,		l: 91,	],
        [ name: "Aqua",						rgb: "#00FFFF",		h: 180,		s: 100,		l: 50,	],
        [ name: "Aquamarine",				rgb: "#7FFFD4",		h: 160,		s: 100,		l: 75,	],
        [ name: "Azure",					rgb: "#F0FFFF",		h: 180,		s: 100,		l: 97,	],
        [ name: "Beige",					rgb: "#F5F5DC",		h: 60,		s: 56,		l: 91,	],
        [ name: "Bisque",					rgb: "#FFE4C4",		h: 33,		s: 100,		l: 88,	],
        [ name: "Blanched Almond",			rgb: "#FFEBCD",		h: 36,		s: 100,		l: 90,	],
        [ name: "Blue",						rgb: "#0000FF",		h: 240,		s: 100,		l: 50,	],
        [ name: "Blue Violet",				rgb: "#8A2BE2",		h: 271,		s: 76,		l: 53,	],
        [ name: "Brown",					rgb: "#A52A2A",		h: 0,		s: 59,		l: 41,	],
        [ name: "Burly Wood",				rgb: "#DEB887",		h: 34,		s: 57,		l: 70,	],
        [ name: "Cadet Blue",				rgb: "#5F9EA0",		h: 182,		s: 25,		l: 50,	],
        [ name: "Chartreuse",				rgb: "#7FFF00",		h: 90,		s: 100,		l: 50,	],
        [ name: "Chocolate",				rgb: "#D2691E",		h: 25,		s: 75,		l: 47,	],
        [ name: "Coral",					rgb: "#FF7F50",		h: 16,		s: 100,		l: 66,	],
        [ name: "Corn Flower Blue",			rgb: "#6495ED",		h: 219,		s: 79,		l: 66,	],
        [ name: "Corn Silk",				rgb: "#FFF8DC",		h: 48,		s: 100,		l: 93,	],
        [ name: "Crimson",					rgb: "#DC143C",		h: 348,		s: 83,		l: 58,	],
        [ name: "Cyan",						rgb: "#00FFFF",		h: 180,		s: 100,		l: 50,	],
        [ name: "Dark Blue",				rgb: "#00008B",		h: 240,		s: 100,		l: 27,	],
        [ name: "Dark Cyan",				rgb: "#008B8B",		h: 180,		s: 100,		l: 27,	],
        [ name: "Dark Golden Rod",			rgb: "#B8860B",		h: 43,		s: 89,		l: 38,	],
        [ name: "Dark Gray",				rgb: "#A9A9A9",		h: 0,		s: 0,		l: 66,	],
        [ name: "Dark Green",				rgb: "#006400",		h: 120,		s: 100,		l: 20,	],
        [ name: "Dark Khaki",				rgb: "#BDB76B",		h: 56,		s: 38,		l: 58,	],
        [ name: "Dark Magenta",				rgb: "#8B008B",		h: 300,		s: 100,		l: 27,	],
        [ name: "Dark Olive Green",			rgb: "#556B2F",		h: 82,		s: 39,		l: 30,	],
        [ name: "Dark Orange",				rgb: "#FF8C00",		h: 33,		s: 100,		l: 50,	],
        [ name: "Dark Orchid",				rgb: "#9932CC",		h: 280,		s: 61,		l: 50,	],
        [ name: "Dark Red",					rgb: "#8B0000",		h: 0,		s: 100,		l: 27,	],
        [ name: "Dark Salmon",				rgb: "#E9967A",		h: 15,		s: 72,		l: 70,	],
        [ name: "Dark Sea Green",			rgb: "#8FBC8F",		h: 120,		s: 25,		l: 65,	],
        [ name: "Dark Slate Blue",			rgb: "#483D8B",		h: 248,		s: 39,		l: 39,	],
        [ name: "Dark Slate Gray",			rgb: "#2F4F4F",		h: 180,		s: 25,		l: 25,	],
        [ name: "Dark Turquoise",			rgb: "#00CED1",		h: 181,		s: 100,		l: 41,	],
        [ name: "Dark Violet",				rgb: "#9400D3",		h: 282,		s: 100,		l: 41,	],
        [ name: "Deep Pink",				rgb: "#FF1493",		h: 328,		s: 100,		l: 54,	],
        [ name: "Deep Sky Blue",			rgb: "#00BFFF",		h: 195,		s: 100,		l: 50,	],
        [ name: "Dim Gray",					rgb: "#696969",		h: 0,		s: 0,		l: 41,	],
        [ name: "Dodger Blue",				rgb: "#1E90FF",		h: 210,		s: 100,		l: 56,	],
        [ name: "Fire Brick",				rgb: "#B22222",		h: 0,		s: 68,		l: 42,	],
        [ name: "Floral White",				rgb: "#FFFAF0",		h: 40,		s: 100,		l: 97,	],
        [ name: "Forest Green",				rgb: "#228B22",		h: 120,		s: 61,		l: 34,	],
        [ name: "Fuchsia",					rgb: "#FF00FF",		h: 300,		s: 100,		l: 50,	],
        [ name: "Gainsboro",				rgb: "#DCDCDC",		h: 0,		s: 0,		l: 86,	],
        [ name: "Ghost White",				rgb: "#F8F8FF",		h: 240,		s: 100,		l: 99,	],
        [ name: "Gold",						rgb: "#FFD700",		h: 51,		s: 100,		l: 50,	],
        [ name: "Golden Rod",				rgb: "#DAA520",		h: 43,		s: 74,		l: 49,	],
        [ name: "Gray",						rgb: "#808080",		h: 0,		s: 0,		l: 50,	],
        [ name: "Green",					rgb: "#008000",		h: 120,		s: 100,		l: 25,	],
        [ name: "Green Yellow",				rgb: "#ADFF2F",		h: 84,		s: 100,		l: 59,	],
        [ name: "Honeydew",					rgb: "#F0FFF0",		h: 120,		s: 100,		l: 97,	],
        [ name: "Hot Pink",					rgb: "#FF69B4",		h: 330,		s: 100,		l: 71,	],
        [ name: "Indian Red",				rgb: "#CD5C5C",		h: 0,		s: 53,		l: 58,	],
        [ name: "Indigo",					rgb: "#4B0082",		h: 275,		s: 100,		l: 25,	],
        [ name: "Ivory",					rgb: "#FFFFF0",		h: 60,		s: 100,		l: 97,	],
        [ name: "Khaki",					rgb: "#F0E68C",		h: 54,		s: 77,		l: 75,	],
        [ name: "Lavender",					rgb: "#E6E6FA",		h: 240,		s: 67,		l: 94,	],
        [ name: "Lavender Blush",			rgb: "#FFF0F5",		h: 340,		s: 100,		l: 97,	],
        [ name: "Lawn Green",				rgb: "#7CFC00",		h: 90,		s: 100,		l: 49,	],
        [ name: "Lemon Chiffon",			rgb: "#FFFACD",		h: 54,		s: 100,		l: 90,	],
        [ name: "Light Blue",				rgb: "#ADD8E6",		h: 195,		s: 53,		l: 79,	],
        [ name: "Light Coral",				rgb: "#F08080",		h: 0,		s: 79,		l: 72,	],
        [ name: "Light Cyan",				rgb: "#E0FFFF",		h: 180,		s: 100,		l: 94,	],
        [ name: "Light Golden Rod Yellow",	rgb: "#FAFAD2",		h: 60,		s: 80,		l: 90,	],
        [ name: "Light Gray",				rgb: "#D3D3D3",		h: 0,		s: 0,		l: 83,	],
        [ name: "Light Green",				rgb: "#90EE90",		h: 120,		s: 73,		l: 75,	],
        [ name: "Light Pink",				rgb: "#FFB6C1",		h: 351,		s: 100,		l: 86,	],
        [ name: "Light Salmon",				rgb: "#FFA07A",		h: 17,		s: 100,		l: 74,	],
        [ name: "Light Sea Green",			rgb: "#20B2AA",		h: 177,		s: 70,		l: 41,	],
        [ name: "Light Sky Blue",			rgb: "#87CEFA",		h: 203,		s: 92,		l: 75,	],
        [ name: "Light Slate Gray",			rgb: "#778899",		h: 210,		s: 14,		l: 53,	],
        [ name: "Light Steel Blue",			rgb: "#B0C4DE",		h: 214,		s: 41,		l: 78,	],
        [ name: "Light Yellow",				rgb: "#FFFFE0",		h: 60,		s: 100,		l: 94,	],
        [ name: "Lime",						rgb: "#00FF00",		h: 120,		s: 100,		l: 50,	],
        [ name: "Lime Green",				rgb: "#32CD32",		h: 120,		s: 61,		l: 50,	],
        [ name: "Linen",					rgb: "#FAF0E6",		h: 30,		s: 67,		l: 94,	],
        [ name: "Maroon",					rgb: "#800000",		h: 0,		s: 100,		l: 25,	],
        [ name: "Medium Aquamarine",		rgb: "#66CDAA",		h: 160,		s: 51,		l: 60,	],
        [ name: "Medium Blue",				rgb: "#0000CD",		h: 240,		s: 100,		l: 40,	],
        [ name: "Medium Orchid",			rgb: "#BA55D3",		h: 288,		s: 59,		l: 58,	],
        [ name: "Medium Purple",			rgb: "#9370DB",		h: 260,		s: 60,		l: 65,	],
        [ name: "Medium Sea Green",			rgb: "#3CB371",		h: 147,		s: 50,		l: 47,	],
        [ name: "Medium Slate Blue",		rgb: "#7B68EE",		h: 249,		s: 80,		l: 67,	],
        [ name: "Medium Spring Green",		rgb: "#00FA9A",		h: 157,		s: 100,		l: 49,	],
        [ name: "Medium Turquoise",			rgb: "#48D1CC",		h: 178,		s: 60,		l: 55,	],
        [ name: "Medium Violet Red",		rgb: "#C71585",		h: 322,		s: 81,		l: 43,	],
        [ name: "Midnight Blue",			rgb: "#191970",		h: 240,		s: 64,		l: 27,	],
        [ name: "Mint Cream",				rgb: "#F5FFFA",		h: 150,		s: 100,		l: 98,	],
        [ name: "Misty Rose",				rgb: "#FFE4E1",		h: 6,		s: 100,		l: 94,	],
        [ name: "Moccasin",					rgb: "#FFE4B5",		h: 38,		s: 100,		l: 85,	],
        [ name: "Navajo White",				rgb: "#FFDEAD",		h: 36,		s: 100,		l: 84,	],
        [ name: "Navy",						rgb: "#000080",		h: 240,		s: 100,		l: 25,	],
        [ name: "Old Lace",					rgb: "#FDF5E6",		h: 39,		s: 85,		l: 95,	],
        [ name: "Olive",					rgb: "#808000",		h: 60,		s: 100,		l: 25,	],
        [ name: "Olive Drab",				rgb: "#6B8E23",		h: 80,		s: 60,		l: 35,	],
        [ name: "Orange",					rgb: "#FFA500",		h: 39,		s: 100,		l: 50,	],
        [ name: "Orange Red",				rgb: "#FF4500",		h: 16,		s: 100,		l: 50,	],
        [ name: "Orchid",					rgb: "#DA70D6",		h: 302,		s: 59,		l: 65,	],
        [ name: "Pale Golden Rod",			rgb: "#EEE8AA",		h: 55,		s: 67,		l: 80,	],
        [ name: "Pale Green",				rgb: "#98FB98",		h: 120,		s: 93,		l: 79,	],
        [ name: "Pale Turquoise",			rgb: "#AFEEEE",		h: 180,		s: 65,		l: 81,	],
        [ name: "Pale Violet Red",			rgb: "#DB7093",		h: 340,		s: 60,		l: 65,	],
        [ name: "Papaya Whip",				rgb: "#FFEFD5",		h: 37,		s: 100,		l: 92,	],
        [ name: "Peach Puff",				rgb: "#FFDAB9",		h: 28,		s: 100,		l: 86,	],
        [ name: "Peru",						rgb: "#CD853F",		h: 30,		s: 59,		l: 53,	],
        [ name: "Pink",						rgb: "#FFC0CB",		h: 350,		s: 100,		l: 88,	],
        [ name: "Plum",						rgb: "#DDA0DD",		h: 300,		s: 47,		l: 75,	],
        [ name: "Powder Blue",				rgb: "#B0E0E6",		h: 187,		s: 52,		l: 80,	],
        [ name: "Purple",					rgb: "#800080",		h: 300,		s: 100,		l: 25,	],
        [ name: "Red",						rgb: "#FF0000",		h: 0,		s: 100,		l: 50,	],
        [ name: "Rosy Brown",				rgb: "#BC8F8F",		h: 0,		s: 25,		l: 65,	],
        [ name: "Royal Blue",				rgb: "#4169E1",		h: 225,		s: 73,		l: 57,	],
        [ name: "Saddle Brown",				rgb: "#8B4513",		h: 25,		s: 76,		l: 31,	],
        [ name: "Salmon",					rgb: "#FA8072",		h: 6,		s: 93,		l: 71,	],
        [ name: "Sandy Brown",				rgb: "#F4A460",		h: 28,		s: 87,		l: 67,	],
        [ name: "Sea Green",				rgb: "#2E8B57",		h: 146,		s: 50,		l: 36,	],
        [ name: "Sea Shell",				rgb: "#FFF5EE",		h: 25,		s: 100,		l: 97,	],
        [ name: "Sienna",					rgb: "#A0522D",		h: 19,		s: 56,		l: 40,	],
        [ name: "Silver",					rgb: "#C0C0C0",		h: 0,		s: 0,		l: 75,	],
        [ name: "Sky Blue",					rgb: "#87CEEB",		h: 197,		s: 71,		l: 73,	],
        [ name: "Slate Blue",				rgb: "#6A5ACD",		h: 248,		s: 53,		l: 58,	],
        [ name: "Slate Gray",				rgb: "#708090",		h: 210,		s: 13,		l: 50,	],
        [ name: "Snow",						rgb: "#FFFAFA",		h: 0,		s: 100,		l: 99,	],
        [ name: "Spring Green",				rgb: "#00FF7F",		h: 150,		s: 100,		l: 50,	],
        [ name: "Steel Blue",				rgb: "#4682B4",		h: 207,		s: 44,		l: 49,	],
        [ name: "Tan",						rgb: "#D2B48C",		h: 34,		s: 44,		l: 69,	],
        [ name: "Teal",						rgb: "#008080",		h: 180,		s: 100,		l: 25,	],
        [ name: "Thistle",					rgb: "#D8BFD8",		h: 300,		s: 24,		l: 80,	],
        [ name: "Tomato",					rgb: "#FF6347",		h: 9,		s: 100,		l: 64,	],
        [ name: "Turquoise",				rgb: "#40E0D0",		h: 174,		s: 72,		l: 56,	],
        [ name: "Violet",					rgb: "#EE82EE",		h: 300,		s: 76,		l: 72,	],
        [ name: "Wheat",					rgb: "#F5DEB3",		h: 39,		s: 77,		l: 83,	],
        [ name: "White Smoke",				rgb: "#F5F5F5",		h: 0,		s: 0,		l: 96,	],
        [ name: "Yellow",					rgb: "#FFFF00",		h: 60,		s: 100,		l: 50,	],
        [ name: "Yellow Green",				rgb: "#9ACD32",		h: 80,		s: 61,		l: 50,	],
    ]
}

/******************************************************************************
FEEDBACK SUPPORT - GET AVERAGE										
******************************************************************************/
def getAverage(device,type){
    def total = 0
    if(debug) log.debug "calculating average temperature"  
    device.each {total += it.latestValue(type)}
    return Math.round(total/device?.size())
}

/************************************************************************************************************
Page status and descriptions 
************************************************************************************************************/       

def pSendSettings() {def result = ""
                     if (echoDevice || synthDevice || sonosDevice || sendContactText || sendText || push || sms || pAlexaCustResp || pAlexaRepeat || pContCmdsProfile || pRunMsg || pPreMsg || pDisableAlexaProfile || pDisableALLProfile || pRunTextMsg || pPreTextMsg) {
                         result = "complete"}
                     result}
def pSendComplete() {def text = "Tap here to Configure" 
                     if (echoDevice ||synthDevice || sonosDevice || sendContactText || sendText || push || sms || pAlexaCustResp || pAlexaRepeat || pContCmdsProfile || pRunMsg || pPreMsg || pDisableAlexaProfile || pDisableALLProfile || pRunTextMsg || pPreTextMsg) {
                         text = "Configured"}
                     else text = "Tap here to Configure"
                     text}
def pMsgSettings() {def result = ""
                     if (echoDevice || synthDevice || sonosDevice || sendContactText || sendText || push || sms || smc) {
                         result = "complete"}
                     result}
def pMsgComplete() {def text = "Tap here to Configure" 
                     if (echoDevice || synthDevice || sonosDevice || sendContactText || sendText || push || sms || smc) {
                         text = "Configured"}
                     else text = "Tap here to Configure"
                     text}
def pConfigSettings() {def result = ""
                       if (pAlexaCustResp || pAlexaRepeat || pContCmdsProfile || pRunMsg || pPreMsg || pDisableAlexaProfile || pDisableALLProfile || pRunTextMsg || pPreTextMsg) {
                           result = "complete"}
                       result}
def pConfigComplete() {def text = "Tap here to Configure" 
                       if (pAlexaCustResp || pAlexaRepeat || pContCmdsProfile || pRunMsg || pPreMsg || pDisableAlexaProfile || pDisableALLProfile || pRunTextMsg || pPreTextMsg) {
                           text = "Configured"}
                       else text = "Tap here to Configure"
                       text}

def pActionsSettings(){def result = ""
                       def pDevicesProc = ""
                       if (sSwitches || sDimmers || sHues || sFlash || pMode || pVirPer) {
                           result = "complete"
                           pDevicesProc = complete}
                       result}
def pActionsComplete() {def text = "" 
                  //      def pDevicesProc = pDevicesComplete()
                        if (pDevicesSettings()=="complete" || pMode || pVirPer) {
                            text = "Configured"}
                        else text = "Tap here to configure"
                        text}        
// PROFILE RESTRICTIONS
def pRestrictSettings(){ def result = "" 
                        if (modes || days || startingX || endingX) { 
                            result = "complete"}
                        result}
def pRestrictComplete() {def text = "Tap here to configure" 
                         if (modes || days || startingX || endingX) {
                             text = "Configured"}
                         else text = "Tap here to Configure"
                         text}
def pTimeSettings(){ def result = "" 
                        if (startingX || endingX) { 
                            result = "complete"}
                        result}
def pTimeComplete() {def text = "Tap here to configure" 
                         if (startingX || endingX) {
                             text = "Configured"}
                         else text = "Tap here to Configure"
                         text}

// FEEDBACK AND CONTROL
def mIntentS(){
	def result = ""
    def IntentS = ""
    if (fPower || ofPower || pActionsSettings() || gDoor1 || sSwitches || sOtherSwitch || sDimmers || sOtherDimmers || sHues || sHuesOther || sFlash || fSwitches || fGarage || fDoors || fWindows || fFans || fVents || fShades || gLocks || fPresence || fMotion || gDisable || gSwitches || gFans || gHues || sVent || sMedia || sSpeaker) {
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

// DEVICE CONTROL GROUPS                         
def pGroupSettings() {def result = ""
                      if (gSwitches || mode || gDisable || gSwitches || gFans || gHues || sVent || sMedia || sSpeaker) {
                          result = "complete"}
                      result}
def pGroupComplete() {def text = "Tap here to Configure" 
                      if (gSwitches || mode || gDisable || gSwitches || gFans || gHues || sVent || sMedia || sSpeaker) {
                          text = "Configured"}
                      else text = "Tap here to Configure"
                      text
                     }
// DEVICE FEEDBACK
def fDeviceSettings() {def result = ""
                      if (fPower || ofPower || fSwitches || fGarage || fDoors || fWindows || fFans || fVents || fShades || gLocks || fPresence || fMotion) {
                          result = "complete"}
                      result}
def fDeviceComplete() {def text = "Configured" 
                      if (fPower || ofPower || fSwitches || fGarage || fDoors || fWindows || fFans || fVents || fShades || gLocks || fPresence || fMotion) {
                          text = "Configured"}
                      else text = "Tap here to Configure"
                      text
                     }
// PROFILE ACTIONS
def pDevicesSettings() {def result = ""
                     if (gDoor1 || sSwitches || sOtherSwitch || sDimmers || sOtherDimmers || sHues || sHuesOther || sFlash) {
                         result = "complete"}
                     result}
def pDevicesComplete() {def text = "Tap here to select devices" 
                     if (gDoor1 || sSwitches || sOtherSwitch || sDimmers || sOtherDimmers || sHues || sHuesOther || sFlash) {
                         text = "Configured"}
                     else text = "Tap here to select devices"
                     text
                     }
// TASK TRACKERS
def pTrackSettings() {def result = ""
                     if (trackerOne2 || trackerTwo2 || trackerThree2 || trackerFour2) {
                         result = "complete"}
                     result}
def pTrackComplete() {def text = "Tap here to configure Task Trackers" 
                     if (trackerOne2 || trackerTwo2 || trackerThree2 || trackerFour2) {
                         text = "Task Trackers Configured"}
                     else text = "Tap here to configure Task Trackers"
                     text}


// VIRTUAL PERSON  
def VPCreateSettings() {def result = ""
                     def deviceId = "${app.label}"
                     def d = getChildDevice("${app.label}")
                     if ("${d}"== ("${app.label}")) {
                         result = "complete"}
                     result}
def VPCreateComplete() {def text = "Tap here to Configure" 
                     def deviceId = "${app.label}"
                     def d = getChildDevice("${app.label}")
                     if ("${d}"== ("${app.label}")) {
                         text = "Virtual Person Created - '$app.label'"}
                     else text = "Tap here to Configure"
                     text}

def VPNotifySettings() {def result = ""
                     if (vpNotification || vpPhone) {
                         result = "complete"}
                     result}
def VPNotifyComplete() {def text = "Tap here to Configure" 
                     if (vpNotification || vpPhone) {
                         text = "Configured"}
                     else text = "Tap here to Configure"
                     text}
def mRoomsS(){
    def result = ""
if (childApps?.size()>0) {
    result = "Complete"	
    }
    result
}
def mRoomsD() {
    def text = "Shortcut have not been created. Tap here to begin"
    if (childApps?.size()>0) {
        if (childApps?.size() == 1) {
        	text = "One shortcut has been created."
        }
        else { 
        	text = childApps?.size() + " shortcuts have been created."
            }
    }
    else text = "Shortcut have not been created. Tap here to begin"
    text
}

/*////////////////////////////////////////////////////////////////////////////////////////////////////
	TASK TRACKER REMINDERS HANDLERS FOLLOW
/////////////////////////////////////////////////////////////////////////////////////////////////////*/

// TASK TRACKER REMINDER #1

page name: "reminderPage1"
def reminderPage1() {
    dynamicPage (name: "reminderPage1", install: false, uninstall: false) {
        section ("Name this Reminder") {
            input "reminderTitle", "text", title:"Reminder Name ", required:true, defaultValue: ""  
        }
        section ("Reminder Type") {  
            input "actionType", "enum", title: "Choose a Notification Type", required: false, defaultValue: "Default", submitOnChange: true, 
                options: ["Custom Sound","Custom Text",]
        }    
        section ("Customize Audio Voice") {	
            input "stVoice", "enum", title: "SmartThings Voice", required: true, defaultValue: "en-US Salli", 
                options: [
                    "da-DK Naja","da-DK Mads","de-DE Marlene","de-DE Hans","en-US Salli","en-US Joey","en-AU Nicole",
                    "en-AU Russell","en-GB Amy","en-GB Brian","en-GB Emma","en-GB Gwyneth","en-GB Geraint","en-IN Raveena","en-US Chipmunk","en-US Eric","en-US Ivy","en-US Jennifer",
                    "en-US Justin","en-US Kendra","en-US Kimberly","es-ES Conchita","es-ES Enrique","es-US Penelope","es-US Miguel","fr-CA Chantal","fr-FR Celine","fr-FR Mathieu",
                    "is-IS Dora","is-IS Karl","it-IT Carla","it-IT Giorgio","nb-NO Liv","nl-NL Lotte","nl-NL Ruben","pl-PL Agnieszka","pl-PL Jacek","pl-PL Ewa","pl-PL Jan",
                    "pl-PL Maja","pt-BR Vitoria","pt-BR Ricardo","pt-PT Cristiano","pt-PT Ines","ro-RO Carmen","ru-RU Tatyana","ru-RU Maxim","sv-SE Astrid","tr-TR Filiz",
                ]
        }
        section ("Output Devices") {
            href "reminderDevices1", title: "Configure Reminder Output Devices"
        }
        if (actionType == "Custom Text") {
            section ("Send this message...") {
                input "reminderText", "text", title: "What do you want the message to say", required: true, defaultValue: "", submitOnChange: true
            }
        }                 
        if (actionType == "Custom Sound") {        
            section ("Play this sound...") {
                input "custSound", "enum", title: "Choose a Sound", required: false, defaultValue: "Bell 1", submitOnChange: true, 
                    options: [
                        "Custom URI","Alexa: Bada Bing Bada Boom","Alexa: Beep Beep","Alexa: Boing","Alexa: Open Sesame","Bell 1","Bell 2",
                        "Dogs Barking","Fire Alarm","The mail has arrived","A door opened","There is motion","Smartthings detected a flood",
                        "Smartthings detected smoke","Soft Chime","Someone is arriving","Piano","Lightsaber"
                    ]
                if(custSound == "Custom URI") {
                    input "cSound", "text", title: "Use this URI", required:false, multiple: false, defaultValue: "", submitOnChange: true
                    if(cSound) input "cDuration", "text", title: "Track Duration", required:true, multiple: false, defaultValue: "10", submitOnChange: true
                }
            }            
        }
        section ("When do you want the reminder?") {
            paragraph "Remember, the reminder is automatically scheduled when the Task Tracker is executed."
            input "reminderType", "enum", title: "Send the reminder in...", required: false, defaultValue: "Default", submitOnChange: true, 
                options: ["Minutes","Hours","Days","Specific Date"]
            if (reminderType == "Minutes") {    
                input "minutes", "number", title: "Send in this many minutes", range: "1..60", required: false, submitOnChange: true
            }
            if (reminderType == "Hours") {
                input "hours", "number", title: "Send in this many hours", range: "1..24", required: false, submitOnChange: true
            }
            if (reminderType == "Days") {
                input "days", "number", title: "Send in this many days", required: false, submitOnChange: true
            }
            if (minutes || hours || days) {
            	input "followUp1", "bool", title: "Would you like a follow-up reminder?", required: false, submitOnChange: true
                if (followUp1) {
		        	paragraph "The follow-up reminder will send the same type reminder as the primary reminder, one time."
            		input "fMinutes1", "number", title: "Send a follow-up reminder in this many minutes (1-120)", range: "1..120", required: false, submitOnChange: true
            		if (fMinutes1) {
                    	input "fRecurring1", "bool", title: "Would you like to have a recurring follow-up reminder?", required: false, submitOnChange: true
                     		if (fRecurring1) paragraph "Recurring reminders will continue to repeat until you manually reset them. You can reset the reminders by 1) Going into the " +
                        "SmartThings mobile app. 2) Telling Alexa that you have completed the task. 3) Telling Alexa to cancel reminders for this profile. "
                     }
                }
            }
        }    
        section ("Unschedule All Reminders") {
            href "unscheduler1", title: "Tap here to unschedule all current reminders for this Task Tracker"
        }
    }
}

page name: "unscheduler1"
def unscheduler1(){
    dynamicPage(name: "unscheduler1", title: "Unschedule Reminders", uninstall: false) {
        section ("") {
            unschedule()
            paragraph "You have successfully unscheduled all Reminders for this Task Tracker. " +
                "Press 'Save' to continue"
        }
    }  
} 

page name: "reminderDevices1"
def reminderDevices1(){
    dynamicPage(name: "reminderDevices1", title: "Configure Reminder Output Types", uninstall: false) {
		section ("") {
        	input "remindSMC1", "bool", title: "Send to Smart Message Control", required: false, submitOnChange: true, defaultValue: false
        }    
        section ("") {
        	input "remindEchoDevice1", "capability.notification", title: "Play on this Amazon Echo Device(s)", required: false, multiple: true, submitOnChange: true
        }
		section ("") {
            input "notifyDevice1", "capability.notification", title: "Display on this Notification Capable Device(s)", required: false, multiple: true, submitOnChange: true
        }
        section (""){
            input "synthDevice1", "capability.speechSynthesis", title: "Play on these Speech Synthesis Devices", multiple: true, required: false, submitOnChange: true
        }
        section ("") {
            input "sonosDevice1", "capability.musicPlayer", title: "Play on these Music Player Devices", required: false, multiple: true, submitOnChange: true    
            if (sonosDevice1) {
                input "volume1", "number", title: "Temporarily change volume", description: "0-100% (default value = 30%)", required: false
            }
        }  
        section ("" ) {
            input "sendText1", "bool", title: "Enable Text Notifications", required: false, submitOnChange: true     
            if (sendText1){      
                paragraph "You may enter multiple phone numbers separated by comma to deliver the Alexa message. E.g. +18045551122,+18046663344"
                input name: "sms1", title: "Send text notification to (optional):", type: "phone", required: false
            }
        }    
        section ("Push Messages") {
            input "push1", "bool", title: "Send Push Notification (optional)", required: false, defaultValue: false
        }        
    }
}

page name: "reminderSMS1"
def reminderSMS1(){
    dynamicPage(name: "reminderSMS1", title: "Send SMS and/or Push Messages...", uninstall: false) {
        section ("Push Messages") {
            input "push1", "bool", title: "Send Push Notification...", required: false, defaultValue: false
            input "timeStamp1", "bool", title: "Add time stamp to Push Messages...", required: false, defaultValue: false  
        }
        section ("Text Messages" , hideWhenEmpty: true) {
            input "sendContactText1", "bool", title: "Enable Text Notifications to Contact Book (if available)", required: false, submitOnChange: true
            if (sendContactText1){
                input "recipients1", "contact", title: "Send text notifications to...", multiple: true, required: false
            }
            input "sendText1", "bool", title: "Enable Text Notifications to non-contact book phone(s)", required: false, submitOnChange: true      
            if (sendText1){      
                paragraph "You may enter multiple phone numbers separated by comma to deliver the Alexa message as a text and a push notification. E.g. 8045551122,8046663344"
                input name: "sms1", title: "Send text notification to...", type: "phone", required: false
            }
        }    
    }        
}
/***********************************************************************************************************************
    TAKE ACTIONS HANDLER
***********************************************************************************************************************/
private takeAction() {
	def tts
	if (fRecurring1 && fMinutes1 && state.fSched1 == "0") {
    	followUpSched1(sched)
        tts = "Attention, This is your follow-up reminder. This reminder will repeat every $fMinutes1 minutes until you manually reset it. " +
        " so please, pay Attention. " + reminderText
        	}
        else if (fMinutes1 && state.fSched1 == "0") {
    	tts = "Attention, This is your only follow-up reminder, it has been $fMinutes1 minutes since your task was due, so please, pay close " + reminderText
        }else {
    			tts = "${reminderText}"
                }
    if (fMinutes1 && state.fSched1 == "1") { 
    	followUpSched1(sched) 
        state.fSched1 = "0"}
        	if (remindSMC1 == true) {
            	sendLocationEvent(name: "SmartMessageControl", value: "ESv5 Room: $app.label", isStateChange: true, descriptionText: "${tts}")
                }
            if (remindEchoDevice1) {	
			settings.remindEchoDevice1.each { dev->
   			dev.speak(tts)
			}
            if (notifyDevice1) {
			settings.notifyDevice1.each { dev->
   			dev.speak(tts)
			}
		}
    }    

    if (synthDevice) {
        synthDevice?.speak(tts) 
    }
    if (tts) {
        state.sound = textToSpeech(tts instanceof List ? tts[9] : tts)
    }
    else {
        state.sound = textToSpeech("You selected the custom message option but did not enter a message in the $app.label Smart App")
    }
    if (sonosDevice){ 
        def currVolLevel = sonosDevice1.latestValue("level")
        def currMuteOn = sonosDevice1.latestValue("mute").contains("muted")
        if (currMuteOn) { 
            if (parent.debug) log.warn "speaker is on mute, sending unmute command"
            sonosDevice1.unmute()
        }
        def sVolume1 = settings.volume1 ?: 20
        sonosDevice1?.playTrackAndResume(state.sound.uri, state.sound.duration, sVolume1)
    }
//    if(sms1){
    sendtxt(tts)
//	}
}    
/***********************************************************************************************************************
    SCHEDULE HANDLER
***********************************************************************************************************************/
def scheduleHandler1(sched) {
	if(reminderType == "Minutes") {
        if(minutes) {
        def timeDateMin = new Date(now()+60000*minutes).format("hh:mm aa", location.timeZone)
            runIn(60 * minutes, "takeAction")
            state.sched = timeDateMin 
            log.info "$state.sched"
        }
    }
    if(reminderType == "Hours") {
        if(hours) {
        def timeDateHours = new Date(now()+3600000*hours).format("hh:mm aa", location.timeZone) 
		def dateDateHours = new Date(now()+3600000*hours).format("EEEE, MMMM d", location.timeZone)
            runIn(3600*hours, "takeAction")
            state.sched = dateDateHours + " at " + timeDateHours 
            log.info "$state.sched"
        }
    }
    if(reminderType == "Days") {
        if(days) {
        	def timeDateHours = new Date(now() + location.timeZone.rawOffset) 
            timeDateHours = timeDateHours.format("hh:mm aa", location.timeZone)
            def dateDateDays = new Date(now() + location.timeZone.rawOffset) + days
            dateDateDays = dateDateDays.format("EEEE, MMMM d, YYYY", location.timeZone)
            runOnce(new Date() + days, "takeAction")
            state.sched = "$dateDateDays at $timeDateHours"
            log.info "${state.sched}"
        return state.sched
        }
    }
    if (fMinutes1) {
    	state.fSched1 = "1"
        }
        return state.sched
}
/***********************************************************************************************************************
    FOLLOW-UP REMINDER HANDLER
***********************************************************************************************************************/
def followUpSched1(sched) {
        if(fMinutes1) {
        def timeDateMin = new Date(now()+60000*fMinutes1).format("hh:mm aa", location.timeZone)
            runIn(60 * fMinutes1, "takeAction")
            state.sched = timeDateMin
            log.info "Follow-up reminder will play at $state.sched"
        return state.sched    
        }
    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////

// TASK TRACKER REMINDER #2

page name: "reminderPage2"
def reminderPage2() {
    dynamicPage (name: "reminderPage2", install: false, uninstall: false) {
        section ("Name this Reminder") {
            input "reminderTitle2", "text", title:"Reminder Name ", required:true, defaultValue: ""  
        }
        section ("Reminder Type") {  
            input "actionType2", "enum", title: "Choose a Notification Type", required: false, defaultValue: "Default", submitOnChange: true, 
                options: ["Custom Sound","Custom Text",]
        }    
        section ("Customize Audio Voice") {	
            input "stVoice2", "enum", title: "SmartThings Voice", required: true, defaultValue: "en-US Salli", 
                options: [
                    "da-DK Naja","da-DK Mads","de-DE Marlene","de-DE Hans","en-US Salli","en-US Joey","en-AU Nicole",
                    "en-AU Russell","en-GB Amy","en-GB Brian","en-GB Emma","en-GB Gwyneth","en-GB Geraint","en-IN Raveena","en-US Chipmunk","en-US Eric","en-US Ivy","en-US Jennifer",
                    "en-US Justin","en-US Kendra","en-US Kimberly","es-ES Conchita","es-ES Enrique","es-US Penelope","es-US Miguel","fr-CA Chantal","fr-FR Celine","fr-FR Mathieu",
                    "is-IS Dora","is-IS Karl","it-IT Carla","it-IT Giorgio","nb-NO Liv","nl-NL Lotte","nl-NL Ruben","pl-PL Agnieszka","pl-PL Jacek","pl-PL Ewa","pl-PL Jan",
                    "pl-PL Maja","pt-BR Vitoria","pt-BR Ricardo","pt-PT Cristiano","pt-PT Ines","ro-RO Carmen","ru-RU Tatyana","ru-RU Maxim","sv-SE Astrid","tr-TR Filiz",
                ]
        }
        section ("Output Devices") {
           href "reminderDevice2", title: "Configure Reminder Output Devices"
        }
        if (actionType == "Custom Text") {
            section ("Send this message...") {
                input "reminderText2", "text", title: "What do you want the message to say", required: true, defaultValue: "", submitOnChange: true
            }
        }                 
        if (actionType == "Custom Sound") {        
            section ("Play this sound...") {
                input "custSound2", "enum", title: "Choose a Sound", required: false, defaultValue: "Bell 1", submitOnChange: true, 
                    options: [
                        "Custom URI",
                        "Alexa: Bada Bing Bada Boom",
                        "Alexa: Beep Beep",
                        "Alexa: Boing",
                        "Alexa: Open Sesame",
                        "Bell 1",
                        "Bell 2",
                        "Dogs Barking",
                        "Fire Alarm",
                        "The mail has arrived",
                        "A door opened",
                        "There is motion",
                        "Smartthings detected a flood",
                        "Smartthings detected smoke",
                        "Soft Chime",
                        "Someone is arriving",
                        "Piano",
                        "Lightsaber"
                    ]
                if(custSound2 == "Custom URI") {
                    input "cSound2", "text", title: "Use this URI", required:false, multiple: false, defaultValue: "", submitOnChange: true
                    if(cSound2) input "cDuration", "text", title: "Track Duration", required:true, multiple: false, defaultValue: "10", submitOnChange: true
                }
            }            
        }
        section ("When do you want the reminder?") {
            paragraph "Remember, the reminder is automatically scheduled when the Task Tracker is executed."
            input "reminderType2", "enum", title: "Send the reminder in...", required: false, defaultValue: "Default", submitOnChange: true, 
                options: ["Minutes","Hours","Days","Specific Date"]
            if (reminderType2 == "Minutes") {    
                input "minutes2", "number", title: "Send in this many minutes", range: "1..59", required: false, submitOnChange: true
            }
            if (reminderType2 == "Hours") {
                input "hours2", "number", title: "Send in this many hours", range: "1..23", required: false, submitOnChange: true
            }
            if (reminderType2 == "Days") {
                input "days2", "number", title: "Send in this many days", required: false, submitOnChange: true
            }
        }    
        section ("Unschedule All Reminders") {
            href "unscheduler1", title: "Tap here to unschedule all current reminders for this Task Tracker"
        }
    }
}

page name: "reminderDevices2"
def reminderDevices2(){
    dynamicPage(name: "reminderDevices2", title: "Configure Reminder Output Types", uninstall: false) {
        section ("") {
            input "notifyDevice2", "capability.notification", title: "Display on this Notification Capable Device(s)", required: false, multiple: true, submitOnChange: true
        }
        section (""){
            input "synthDevice2", "capability.speechSynthesis", title: "Play on these Speech Synthesis Devices", multiple: true, required: false, submitOnChange: true
        }
        section ("") {
            input "sonosDevice2", "capability.musicPlayer", title: "Play on these Music Player Devices", required: false, multiple: true, submitOnChange: true    
            if (sonosDevice2) {
                input "volume2", "number", title: "Temporarily change volume", description: "0-100% (default value = 30%)", required: false
            }
        }  
        section ("" ) {
            input "sendText2", "bool", title: "Enable Text Notifications", required: false, submitOnChange: true     
            if (sendText2){      
                paragraph "You may enter multiple phone numbers separated by comma to deliver the Alexa message. E.g. +18045551122,+18046663344"
                input name: "sms2", title: "Send text notification to (optional):", type: "phone", required: false
            }
        }    
        section ("Push Messages") {
            input "push2", "bool", title: "Send Push Notification (optional)", required: false, defaultValue: false
        }        
    }
}

page name: "reminderSMS2"
def reminderSMS2(){
    dynamicPage(name: "reminderSMS2", title: "Send SMS and/or Push Messages...", uninstall: false) {
        section ("Push Messages") {
            input "push2", "bool", title: "Send Push Notification...", required: false, defaultValue: false
            input "timeStamp2", "bool", title: "Add time stamp to Push Messages...", required: false, defaultValue: false  
        }
        section ("Text Messages" , hideWhenEmpty: true) {
            input "sendContactText2", "bool", title: "Enable Text Notifications to Contact Book (if available)", required: false, submitOnChange: true
            if (sendContactText2){
                input "recipients2", "contact", title: "Send text notifications to...", multiple: true, required: false
            }
            input "sendText2", "bool", title: "Enable Text Notifications to non-contact book phone(s)", required: false, submitOnChange: true      
            if (sendText2){      
                paragraph "You may enter multiple phone numbers separated by comma to deliver the Alexa message as a text and a push notification. E.g. 8045551122,8046663344"
                input name: "sms2", title: "Send text notification to...", type: "phone", required: false
            }
        }    
    }        
}

/***********************************************************************************************************************
    TAKE ACTIONS HANDLER
***********************************************************************************************************************/
private takeAction2() {
    def tts = "${reminderText2}"
    if (synthDevice2 || notifyDevice2) {
        synthDevice2?.speak(tts2) 
    }
    if (tts) {
        state.sound = textToSpeech(tts instanceof List ? tts[9] : tts)
    }
    else {
        state.sound = textToSpeech("You selected the custom message option but did not enter a message in the $app.label Smart App")
    }
    if (sonosDevice2){ 
        def currVolLevel2 = sonosDevice2.latestValue("level")
        def currMuteOn2 = sonosDevice2.latestValue("mute").contains("muted")
        if (currMuteOn2) { 
            if (parent.debug) log.warn "speaker is on mute, sending unmute command"
            sonosDevice2.unmute()
        }
        def sVolume2 = settings.volume ?: 20
        sonosDevice2?.playTrackAndResume(state.sound.uri, state.sound.duration, sVolume)
    } 
    sendtxt(tts)
}
/***********************************************************************************************************************
    SCHEDULE HANDLER
***********************************************************************************************************************/
def scheduleHandler2(sched) {
    if(reminderType2 == "Minutes") {
        if(minutes2) {
        def timeDateMin = new Date(now()+60000*minutes2).format("hh:mm aa", location.timeZone)
            runIn(60 * minutes2, "takeAction2")
            state.sched2 = timeDateMin 
            log.info "$state.sched2"
        return state.sched2    
        }
    }
    if(reminderType2 == "Hours") {
        if(hours2) {
        def timeDateHours = new Date(now()+3600000*hours2).format("hh:mm aa", location.timeZone) 
		def dateDateHours = new Date(now()+3600000*hours2).format("EEEE, MMMM d", location.timeZone)
            runIn(3600*hours2, "takeAction2")
            state.sched2 = dateDateHours + " at " + timeDateHours 
            log.info "$state.sched2"
        return state.sched2
        }
    }
    if(reminderType == "Days") {
        if(days2) {
        	def timeDateHours = new Date(now()+86400000*days).format("hh:mm aa", location.timeZone)
            def dateDateDays = new Date(now()+86400000*days).format("EEEE, MMMM d, YYYY", location.timeZone)
            runOnce(new Date(now()+86400000*days2), "takeAction2")
            state.sched = dateDateDays + " at " + timeDateHours
            log.info "${state.sched2}"
        return state.sched2
        }
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

// TASK TRACKER REMINDER #3

page name: "reminderPage3"
def reminderPage3() {
    dynamicPage (name: "reminderPage3",install: false, uninstall: false) {
        section ("Name this Reminder") {
            input "reminderTitle3", "text", title:"Reminder Name ", required:true, defaultValue: ""  
        }
        section ("Reminder Type") {  
            input "actionType3", "enum", title: "Choose a Notification Type", required: false, defaultValue: "Default", submitOnChange: true, 
                options: ["Custom Sound","Custom Text",]
        }    
        section ("Customize Audio Voice") {	
            input "stVoice3", "enum", title: "SmartThings Voice", required: true, defaultValue: "en-US Salli", 
                options: [
                    "da-DK Naja","da-DK Mads","de-DE Marlene","de-DE Hans","en-US Salli","en-US Joey","en-AU Nicole",
                    "en-AU Russell","en-GB Amy","en-GB Brian","en-GB Emma","en-GB Gwyneth","en-GB Geraint","en-IN Raveena","en-US Chipmunk","en-US Eric","en-US Ivy","en-US Jennifer",
                    "en-US Justin","en-US Kendra","en-US Kimberly","es-ES Conchita","es-ES Enrique","es-US Penelope","es-US Miguel","fr-CA Chantal","fr-FR Celine","fr-FR Mathieu",
                    "is-IS Dora","is-IS Karl","it-IT Carla","it-IT Giorgio","nb-NO Liv","nl-NL Lotte","nl-NL Ruben","pl-PL Agnieszka","pl-PL Jacek","pl-PL Ewa","pl-PL Jan",
                    "pl-PL Maja","pt-BR Vitoria","pt-BR Ricardo","pt-PT Cristiano","pt-PT Ines","ro-RO Carmen","ru-RU Tatyana","ru-RU Maxim","sv-SE Astrid","tr-TR Filiz",
                ]
        }
        section ("Output Devices") {
            href "reminderDevices3", title: "Configure Reminder Output Devices"
        }
        if (actionType3 == "Custom Text") {
            section ("Send this message...") {
                input "reminderText3", "text", title: "What do you want the message to say", required: true, defaultValue: "", submitOnChange: true
            }
        }                 
        if (actionType3 == "Custom Sound") {        
            section ("Play this sound...") {
                input "custSound3", "enum", title: "Choose a Sound", required: false, defaultValue: "Bell 1", submitOnChange: true, 
                    options: [
                        "Custom URI",
                        "Alexa: Bada Bing Bada Boom",
                        "Alexa: Beep Beep",
                        "Alexa: Boing",
                        "Alexa: Open Sesame",
                        "Bell 1",
                        "Bell 2",
                        "Dogs Barking",
                        "Fire Alarm",
                        "The mail has arrived",
                        "A door opened",
                        "There is motion",
                        "Smartthings detected a flood",
                        "Smartthings detected smoke",
                        "Soft Chime",
                        "Someone is arriving",
                        "Piano",
                        "Lightsaber"
                    ]
                if(custSound3 == "Custom URI") {
                    input "cSound3", "text", title: "Use this URI", required:false, multiple: false, defaultValue: "", submitOnChange: true
                    if(cSound3) input "cDuration3", "text", title: "Track Duration", required:true, multiple: false, defaultValue: "10", submitOnChange: true
                }
            }            
        }
        section ("When do you want the reminder?") {
            paragraph "Remember, the reminder is automatically scheduled when the Task Tracker is executed."
            input "reminderType3", "enum", title: "Send the reminder in...", required: false, defaultValue: "Default", submitOnChange: true, 
                options: ["Minutes","Hours","Days","Specific Date"]
            if (reminderType3 == "Minutes") {    
                input "minutes3", "number", title: "Send in this many minutes", range: "1..59", required: false, submitOnChange: true
            }
            if (reminderType3 == "Hours") {
                input "hours3", "number", title: "Send in this many hours", range: "1..23", required: false, submitOnChange: true
            }
            if (reminderType3 == "Days") {
                input "days3", "number", title: "Send in this many days", required: false, submitOnChange: true
            }
            if (reminderType3 == "Specific Date") {
                input "xFutureTime3", "time", title: "At this time...",  required: false, submitOnChange: true
                def todayYear3 = new Date(now()).format("yyyy")
                def todayMonth3 = new Date(now()).format("MMMM")
                def todayDay3 = new Date(now()).format("dd")
                input "xFutureDay3", "number", title: "On this Day - maximum 31", range: "1..31", submitOnChange: true, description: "Example: ${todayDay}", required: false
                if(xFutureDay3) input "xFutureMonth3", "enum", title: "Of this Month", submitOnChange: true, required: false, multiple: false, description: "Example: ${todayMonth}",
                    options: ["1": "January", "2":"February", "3":"March", "4":"April", "5":"May", "6":"June", "7":"July", "8":"August", "9":"September", "10":"October", "11":"November", "12":"December"]
                if(xFutureMonth3) input "xFutureYear3", "number", title: "Of this Year - maximum 2025", range: "2017..2025", submitOnChange: true, description: "Example: ${todayYear}", required: false
            }
        }    
        section ("Unschedule All Reminders") {
            href "unscheduler3", title: "Tap here to unschedule all current reminders for this Task Tracker"
        }
    }
}

page name: "unscheduler3"
def unscheduler3(){
    dynamicPage(name: "unscheduler3", title: "Unschedule Reminders", uninstall: false) {
        section ("") {
            unschedule()
            paragraph "You have successfully unscheduled all Reminders for this Task Tracker. " +
                "Press 'Save' to continue"
        }
    }  
} 

page name: "reminderDevices3"
def reminderDevices3(){
    dynamicPage(name: "reminderDevices3", title: "Configure Reminder Output Types", uninstall: false) {
        section ("") {
            input "notifyDevice3", "capability.notification", title: "Display on this Notification Capable Device(s)", required: false, multiple: true, submitOnChange: true
        }
        section (""){
            input "synthDevice3", "capability.speechSynthesis", title: "Play on these Speech Synthesis Devices", multiple: true, required: false, submitOnChange: true
        }
        section ("") {
            input "sonosDevice3", "capability.musicPlayer", title: "Play on these Music Player Devices", required: false, multiple: true, submitOnChange: true    
            if (sonosDevice3) {
                input "volume3", "number", title: "Temporarily change volume", description: "0-100% (default value = 30%)", required: false
            }
        }  
        section ("" ) {
            input "sendText3", "bool", title: "Enable Text Notifications", required: false, submitOnChange: true     
            if (sendText3){      
                paragraph "You may enter multiple phone numbers separated by comma to deliver the Alexa message. E.g. +18045551122,+18046663344"
                input name: "sms3", title: "Send text notification to (optional):", type: "phone", required: false
            }
        }    
        section ("Push Messages") {
            input "push3", "bool", title: "Send Push Notification (optional)", required: false, defaultValue: false
        }        
    }
}

page name: "reminderSMS3"
def reminderSMS3(){
    dynamicPage(name: "reminderSMS3", title: "Send SMS and/or Push Messages...", uninstall: false) {
        section ("Push Messages") {
            input "push3", "bool", title: "Send Push Notification...", required: false, defaultValue: false
            input "timeStamp3", "bool", title: "Add time stamp to Push Messages...", required: false, defaultValue: false  
        }
        section ("Text Messages" , hideWhenEmpty: true) {
            input "sendContactText3", "bool", title: "Enable Text Notifications to Contact Book (if available)", required: false, submitOnChange: true
            if (sendContactText3){
                input "recipients3", "contact", title: "Send text notifications to...", multiple: true, required: false
            }
            input "sendText3", "bool", title: "Enable Text Notifications to non-contact book phone(s)", required: false, submitOnChange: true      
            if (sendText3){      
                paragraph "You may enter multiple phone numbers separated by comma to deliver the Alexa message as a text and a push notification. E.g. 8045551122,8046663344"
                input name: "sms3", title: "Send text notification to...", type: "phone", required: false
            }
        }    
    }        
}

/***********************************************************************************************************************
    TAKE ACTIONS HANDLER
***********************************************************************************************************************/
private takeAction3() {
    def tts3 = "${reminderText3}"
    if (synthDevice3 || notifyDevice3) {
        synthDevice3?.speak(tts3) 
    }
    if (tts3) {
        state.sound3 = textToSpeech(tts3 instanceof List ? tts[9] : tts3)
    }
    else {
        state3.sound = textToSpeech("You selected the custom message option but did not enter a message in the $app.label Smart App")
    }
    if (sonosDevice3){ 
        def currVolLevel3 = sonosDevice3.latestValue("level")
        def currMuteOn3 = sonosDevice3.latestValue("mute").contains("muted")
        if (currMuteOn3) { 
            if (parent.debug) log.warn "speaker is on mute, sending unmute command"
            sonosDevice3.unmute()
        }
        def sVolume3 = settings.volume ?: 20
        sonosDevice3?.playTrackAndResume(state.sound.uri, state.sound.duration, sVolume)
    } 
    sendtxt(tts3)
}
/***********************************************************************************************************************
    CRON HANDLER
***********************************************************************************************************************/
def scheduleHandler3() {
    if(reminderType3 == "Minutes") {
        if(minutes3) { 
            runIn(60 * minutes3, "takeAction3")
        }
    }
    if(reminderType3 == "Hours") {
        if(hours3) {
            runIn(3600 * hours3, "takeAction3")
        }
    }
    if(reminderType == "Days") {
        if(days3) {
            runIn(new Date() + days3, "takeAction3")
        }
    }
    if(reminderType3 == "Specific Date") {
        if(xFutureDay3) {
            oneTimeHandler3()
        }
    }
}

/***********************************************************************************************************************
    ONE TIME SCHEDULING HANDLER
***********************************************************************************************************************/
def oneTimeHandler3() {
    def result
    def todayYear3 = new Date(now()).format("yyyy")
    def todayMonth3 = new Date(now()).format("MM")
    def todayDay3 = new Date(now()).format("dd")
    def yyyy = xFutureYear3 ?: todayYear
    def MM = xFutureMonth3 ?: todayMonth
    def dd = xFutureDay3 ?: todayDay

    if(!xFutureDay3) {
        runOnce(xFutureTime3, "takeAction3")
    }
    else{
        def timeSchedule3 = hhmmssZ(xFutureTime3)
        result = "${yyyy}-${MM}-${dd}T${timeSchedule3}" 
        Date date = Date.parse("yyyy-MM-dd'T'HH:mm:ss.SSSZ", result)
        runOnce(date, "takeAction3")
    }
}
private hhmmssZ3(time, fmt = "HH:mm:ss.SSSZ") {
    def t = timeToday(time, location.timeZone)
    def f = new java.text.SimpleDateFormat(fmt)
    f.setTimeZone(location.timeZone ?: timeZone(time))
    f.format(t)
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

// TASK TRACKER REMINDER #4

page name: "reminderPage4"
def reminderPage4() {
    dynamicPage (name: "reminderPage4", install: false, uninstall: false) {
        section ("Name this Reminder") {
            input "reminderTitle4", "text", title:"Reminder Name ", required:true, defaultValue: ""  
        }
        section ("Reminder Type") {  
            input "actionType4", "enum", title: "Choose a Notification Type", required: false, defaultValue: "Default", submitOnChange: true, 
                options: [
                    "Custom Sound",
                    "Custom Text",
                ]
        }    
        section ("Customize Audio Voice") {	
            input "stVoice4", "enum", title: "SmartThings Voice", required: true, defaultValue: "en-US Salli", 
                options: [
                    "da-DK Naja","da-DK Mads","de-DE Marlene","de-DE Hans","en-US Salli","en-US Joey","en-AU Nicole",
                    "en-AU Russell","en-GB Amy","en-GB Brian","en-GB Emma","en-GB Gwyneth","en-GB Geraint","en-IN Raveena","en-US Chipmunk","en-US Eric","en-US Ivy","en-US Jennifer",
                    "en-US Justin","en-US Kendra","en-US Kimberly","es-ES Conchita","es-ES Enrique","es-US Penelope","es-US Miguel","fr-CA Chantal","fr-FR Celine","fr-FR Mathieu",
                    "is-IS Dora","is-IS Karl","it-IT Carla","it-IT Giorgio","nb-NO Liv","nl-NL Lotte","nl-NL Ruben","pl-PL Agnieszka","pl-PL Jacek","pl-PL Ewa","pl-PL Jan",
                    "pl-PL Maja","pt-BR Vitoria","pt-BR Ricardo","pt-PT Cristiano","pt-PT Ines","ro-RO Carmen","ru-RU Tatyana","ru-RU Maxim","sv-SE Astrid","tr-TR Filiz",
                ]
        }
        section ("Output Devices") {
            href "reminderDevices4", title: "Configure Reminder Output Devices"
        }
        if (actionType4 == "Custom Text") {
            section ("Send this message...") {
                input "reminderText4", "text", title: "What do you want the message to say", required: true, defaultValue: "", submitOnChange: true
            }
        }                 
        if (actionType4 == "Custom Sound") {        
            section ("Play this sound...") {
                input "custSound4", "enum", title: "Choose a Sound", required: false, defaultValue: "Bell 1", submitOnChange: true, 
                    options: [
                        "Custom URI",
                        "Alexa: Bada Bing Bada Boom",
                        "Alexa: Beep Beep",
                        "Alexa: Boing",
                        "Alexa: Open Sesame",
                        "Bell 1",
                        "Bell 2",
                        "Dogs Barking",
                        "Fire Alarm",
                        "The mail has arrived",
                        "A door opened",
                        "There is motion",
                        "Smartthings detected a flood",
                        "Smartthings detected smoke",
                        "Soft Chime",
                        "Someone is arriving",
                        "Piano",
                        "Lightsaber"
                    ]
                if(custSound4 == "Custom URI") {
                    input "cSound4", "text", title: "Use this URI", required:false, multiple: false, defaultValue: "", submitOnChange: true
                    if(cSound4) input "cDuration4", "text", title: "Track Duration", required:true, multiple: false, defaultValue: "10", submitOnChange: true
                }
            }            
        }
        section ("When do you want the reminder?") {
            paragraph "Remember, the reminder is automatically scheduled when the Task Tracker is executed."
            input "reminderType4", "enum", title: "Send the reminder in...", required: false, defaultValue: "Default", submitOnChange: true, 
                options: [
                    "Minutes",
                    "Hours",
                    "Days",
                    "Specific Date"
                ]
            if (reminderType4 == "Minutes") {    
                input "minutes4", "number", title: "Send in this many minutes", range: "1..59", required: false, submitOnChange: true
            }
            if (reminderType4 == "Hours") {
                input "hours4", "number", title: "Send in this many hours", range: "1..23", required: false, submitOnChange: true
            }
            if (reminderType4 == "Days") {
                input "days4", "number", title: "Send in this many days", required: false, submitOnChange: true
            }
            if (reminderType4 == "Specific Date") {
                input "xFutureTime4", "time", title: "At this time...",  required: false, submitOnChange: true
                def todayYear4 = new Date(now()).format("yyyy")
                def todayMonth4 = new Date(now()).format("MMMM")
                def todayDay4 = new Date(now()).format("dd")
                input "xFutureDay4", "number", title: "On this Day - maximum 31", range: "1..31", submitOnChange: true, description: "Example: ${todayDay}", required: false
                if(xFutureDay4) input "xFutureMonth2", "enum", title: "Of this Month", submitOnChange: true, required: false, multiple: false, description: "Example: ${todayMonth}",
                    options: ["1": "January", "2":"February", "3":"March", "4":"April", "5":"May", "6":"June", "7":"July", "8":"August", "9":"September", "10":"October", "11":"November", "12":"December"]
                if(xFutureMonth4) input "xFutureYear4", "number", title: "Of this Year - maximum 2025", range: "2017..2025", submitOnChange: true, description: "Example: ${todayYear}", required: false
            }
        }    
        section ("Unschedule All Reminders") {
            href "unscheduler4", title: "Tap here to unschedule all current reminders for this Task Tracker"

        }
    }
}

page name: "unscheduler4"
def unscheduler4(){
    dynamicPage(name: "unscheduler4", title: "Unschedule Reminders", uninstall: false) {
        section ("") {
            unschedule()
            paragraph "You have successfully unscheduled all Reminders for this Task Tracker. " +
                "Press 'Save' to continue"
        }
    }  
}    
page name: "reminderDevices4"
def reminderDevices4(){
    dynamicPage(name: "reminderDevices4", title: "Configure Reminder Output Types", uninstall: false) {
        section ("") {
            input "notifyDevice4", "capability.notification", title: "Display on this Notification Capable Device(s)", required: false, multiple: true, submitOnChange: true
        }
        section (""){
            input "synthDevice4", "capability.speechSynthesis", title: "Play on these Speech Synthesis Devices", multiple: true, required: false, submitOnChange: true
        }
        section ("") {
            input "sonosDevice4", "capability.musicPlayer", title: "Play on these Music Player Devices", required: false, multiple: true, submitOnChange: true    
            if (sonosDevice4) {
                input "volume4", "number", title: "Temporarily change volume", description: "0-100% (default value = 30%)", required: false
            }
        }  
        section ("" ) {
            input "sendText4", "bool", title: "Enable Text Notifications", required: false, submitOnChange: true     
            if (sendText4){      
                paragraph "You may enter multiple phone numbers separated by comma to deliver the Alexa message. E.g. +18045551122,+18046663344"
                input name: "sms4", title: "Send text notification to (optional):", type: "phone", required: false
            }
        }    
        section ("Push Messages") {
            input "push4", "bool", title: "Send Push Notification (optional)", required: false, defaultValue: false
        }        
    }
}    
page name: "reminderSMS4"
def reminderSMS4(){
    dynamicPage(name: "reminderSMS4", title: "Send SMS and/or Push Messages...", uninstall: false) {
        section ("Push Messages") {
            input "push4", "bool", title: "Send Push Notification...", required: false, defaultValue: false
            input "timeStamp4", "bool", title: "Add time stamp to Push Messages...", required: false, defaultValue: false  
        }
        section ("Text Messages" , hideWhenEmpty: true) {
            input "sendContactText4", "bool", title: "Enable Text Notifications to Contact Book (if available)", required: false, submitOnChange: true
            if (sendContactText4){
                input "recipients4", "contact", title: "Send text notifications to...", multiple: true, required: false
            }
            input "sendText4", "bool", title: "Enable Text Notifications to non-contact book phone(s)", required: false, submitOnChange: true      
            if (sendText4){      
                paragraph "You may enter multiple phone numbers separated by comma to deliver the Alexa message as a text and a push notification. E.g. 8045551122,8046663344"
                input name: "sms4", title: "Send text notification to...", type: "phone", required: false
            }
        }    
    }        
}

/***********************************************************************************************************************
TASK TRACKER REMINDERS TAKE ACTIONS HANDLER
***********************************************************************************************************************/
private takeAction4() {
    def tts = "${reminderText4}"
    if (synthDevice2 || notifyDevice4) {
        synthDevice4?.speak(tts) 
    }
    if (tts) {
        state.sound = textToSpeech(tts instanceof List ? tts[9] : tts)
    }
    else {
        state.sound = textToSpeech("You selected the custom message option but did not enter a message in the $app.label Smart App")
    }
    if (sonosDevice4){ 
        def currVolLevel = sonosDevice4.latestValue("level")
        def currMuteOn = sonosDevice4.latestValue("mute").contains("muted")
        if (currMuteOn) { 
            if (parent.debug) log.warn "speaker is on mute, sending unmute command"
            sonosDevic4.unmute()
        }
        def sVolume = settings.volume ?: 20
        sonosDevice4?.playTrackAndResume(state.sound.uri, state.sound.duration, sVolume)
    } 
    sendtxt(tts)
}
/***********************************************************************************************************************
TASK TRACKER REMINDERS SCHEDULING HANDLER
***********************************************************************************************************************/
def scheduleHandler4() {
    if(reminderType4 == "Minutes") {
        if(minutes4) { 
            runIn(60 * minutes4, "takeAction4")
        }
    }
    if(reminderType4 == "Hours") {
        if(hours4) {
            runIn(3600 * hours4, "takeAction4")
        }
    }
    if(reminderType4 == "Days") {
        if(days4) {
            runIn(new Date() + days4, "takeAction4")
        }
    }
    if(reminderType4 == "Specific Date") {
        if(xFutureDay4) {
            oneTimeHandler4()
        }
    }
}

/***********************************************************************************************************************
ONE TIME SCHEDULING HANDLER
***********************************************************************************************************************/
def oneTimeHandler4() {
    def result
    def todayYear = new Date(now()).format("yyyy")
    def todayMonth = new Date(now()).format("MM")
    def todayDay = new Date(now()).format("dd")
    def yyyy = xFutureYear4 ?: todayYear
    def MM = xFutureMonth4 ?: todayMonth
    def dd = xFutureDay4 ?: todayDay

    if(!xFutureDay4) {
        runOnce(xFutureTime4, "takeAction")
    }
    else{
        def timeSchedule = hhmmssZ(xFutureTime4)
        result = "${yyyy}-${MM}-${dd}T${timeSchedule4}" 
        Date date = Date.parse("yyyy-MM-dd'T'HH:mm:ss.SSSZ", result)
        runOnce(date, "takeAction")
    }
}
private hhmmssZ4(time, fmt = "HH:mm:ss.SSSZ") {
    def t = timeToday(time, location.timeZone)
    def f = new java.text.SimpleDateFormat(fmt)
    f.setTimeZone(location.timeZone ?: timeZone(time))
    f.format(t)
}


def listEchoSistantProfiles() {
log.warn "child requesting esProfiles"
	return state.esProfiles = state.esProfiles ? state.esProfiles : []
//	return state.lrBlockz = state.lrBlockz ? state.lrBlockz : []
}

/********************************************************************************************
*********************************************************************************************
	LOGIC RULES/LOGIC BLOCKS GRANDCHILD APP FOLLOWS
********************************************************************************************
********************************************************************************************/
    

/**********************************************************************************************************************************************/
private def LBtextVersion() {
	def text = "2.0"
}
private LBrelease() {
    def text = "Ver R.0.5.0 5-Dec-2018"
}
/**********************************************************************************************************************************************/

page name: "LogicBlocks"
def LogicBlocks() {
    dynamicPage (name: "LogicBlocks", title: "", install: false, uninstall: false) {  
        section("Create and Manage Logic Blockz") {
            href "blockzPage", title: "Manage Logic Blockz", description: mRoomsD(), state: mRoomsS(), image:"https://raw.githubusercontent.com/jasonrwise77/My-SmartThings/master/LogicRulz%20Icons/Blok.png" 
            }
        section("Logic Block Details",  uninstall: false){
            href "statusPage", title: "View the details of your Logic Blockz", description: mBlocksD(), state: mBlocksS(), image:"https://raw.githubusercontent.com/jasonrwise77/My-SmartThings/master/LogicRulz%20Icons/logic%20Blok.png"
            }
        section("Pause Logic Blockz") {
        	input "aPause", "bool", title: "Turn off this toggle to pause ALL Logic Blockz in the $app.label", defaultValue: true, submitOnChange: true, image:"https://raw.githubusercontent.com/jasonrwise77/My-SmartThings/master/LogicRulz%20Icons/pause.png"
        	}
        section("Settings") {
        	href "settingsPage", title: "Configure Settings", description: mSettingsD(), state: mSettingsS(), image:"https://raw.githubusercontent.com/jasonrwise77/My-SmartThings/master/LogicRulz%20Icons/settings.png"
            }
	    }
	}


page name: "settingsPage"
	def settingsPage() {
    	dynamicPage (name: "settingsPage", title: "Tap here to configure settings") {
        section("") {
            input "debug", "bool", title: "Enable Debug Logging", default: true, submitOnChange: true, image:"https://raw.githubusercontent.com/jasonrwise77/My-SmartThings/master/LogicRulz%20Icons/DeBug.jpg"
        	input "trace", "bool", title: "Enable Trace Logging", default: false, submitOnChange: true, image:"https://raw.githubusercontent.com/jasonrwise77/My-SmartThings/master/LogicRulz%20Icons/DeBug.jpg"
            paragraph "Debug logging is for normal use, Trace logging is for when we have a problem"
			}
        section("App Details") {
            paragraph "Parent App Version: ${LBtextVersion()} | Release: ${LBrelease()}", image:"https://raw.githubusercontent.com/jasonrwise77/My-SmartThings/master/LogicRulz%20Icons/LogicRulz.png"
        	}
        }    
	}
        
page name: "statusPage"
    def statusPage() {
    	dynamicPage (name: "statusPage", title: "You have created (${childApps?.size()}) Logic Blockz", install: true, uninstall: installed) {
    		section("Paused Logic Blockz"){
            paragraph runningAppsFalse()  
            }
            section("Running Logic Blockz") {
            paragraph runningAppsTrue()
            }
        }
    }    
page name: "blockzPage"
    def blockzPage() {
    	dynamicPage (name: "blockzPage", title: "You have created (${childApps?.size()}) Blockz", install: false, uninstall: installed) {
    		section(""){
            app(name: "EchoSistant Logic Blockz", appName: "EchoSistant Logic Blockz", title: "Create a new Logic Block", namespace: "Echo", displayChildApps: true, multiple: true,  uninstall: false)
            }
		}
    }    

// METHOD FOR LOGIC BLOCK DETAILS - RUNNING APPS SECTION
private runningAppsTrue() { 
    def runBlock = []
    def children = getChildApps()
    children?.each { child ->
        if (child.rPause == true) {
            def running = (child?.appStatusTrue())
            state.theRunning = "$running "
            paragraph "${state.theRunning}" 
            String run  = (String) child
            runBlock += run
        }
    }
    	state.runBlock = runBlock.size()
        if (state.theRunning == null) {
        paragraph "All Logic Blocks are Currently Paused" 
        }
    return 
}

// METHOD FOR LOGIC BLOCK DETAILS - PAUSED APPS SECTION
private runningAppsFalse() {
	def pauseBlock = []
    def children = getChildApps()
    children?.each { child ->
        if (child.rPause == false) {
            def paused = (child?.appStatusFalse())
            state.thePaused = "$paused "
            paragraph "${state.thePaused}"
            String pause  = (String) child
            pauseBlock += pause
            }
        }    
        state.pauseBlock = pauseBlock.size()
        if (state.thePaused == null) {
        paragraph "All Logic Blocks are Currently Running" 
        }
    return 
}

// METHOD FOR LOGIC BLOCK DETAILS - RUNNING APPS COUNT
private runningAppsTrueUpdate() {
	def result
    def runBlock = []
    def children = getChildApps()
    children?.each { child ->
        if (child.rPause == true) {
            def running = (child?.appStatusTrue())
            state.theRunning = "$running "
            result = "${state.theRunning}" 
            String run  = (String) child
            runBlock += run
        }
    }
    	state.runBlock = runBlock.size()
        if (state.theRunning == null) {
        result = "All Logic Blocks are Currently Paused" 
        }
    return result
}

// METHOD FOR LOGIC BLOCK DETAILS - RUNNING APPS COUNT
private runningAppsFalseUpdate() {
	def result
	def pauseBlock = []
    def children = getChildApps()
    children?.each { child ->
        if (child.rPause == false) {
            def paused = (child?.appStatusFalse())
            state.thePaused = "$paused "
            result = "${state.thePaused}"
            String pause  = (String) child
            pauseBlock += pause
            }
        }    
        state.pauseBlock = pauseBlock.size()
        if (state.thePaused == null) {
        result = "All Logic Blocks are Currently Running" 
        }
    return result
}

/** Configure Profiles Pages **/
def mRoomsSL(){
    def result = ""
    if (childApps?.size()) {
    	result = "complete"	
    }
    result
}
def mRoomsDL() {
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
def getProfileList(){
		return getChildApps()*.label
}
/** Configure Settings Pages **/
def mSettingsS(){
    def result = ""
    if (debug == true && trace == true) {
    	result = "complete"	
    }
    result
}
def mSettingsD() {
    def text = "Settings have not been configured. Tap here to begin"
    if ("$debug" == true) { debug = "Debug Logging is Active" }
    if ("$debug" == false) { debug = "Dubug Logging is not Active" }
    if ("$trace" == true) { trace = "Trace Logging is Active" }
    if ("$trace" == false) { trace = "Trace Logging is not Active" }
    	text = "Debug Logging is $debug \n" +
        	"Trace Logging is $trace "
}                     


def mBlocksS(){
    def result = ""
    if (state.runBlock > 0) {
    	result = "complete"	
    }
    result
}
def mBlocksD() {
    def text = "Logic Blockz have not been created. Tap here to begin"
    	text = "There are $state.runBlock running Logic Blockz \n" +
        	"and $state.pauseBlock paused Logic Blockz "
}                     

def listRemindRProfiles() {
log.warn "child requesting RemindR Profiles"
log.info "RemindR Profile List = $state.rProfiles"
	return state.profiles = state.profiles ? state.profiles : []
}

// INTEGRATION WITH REMINDR
def remindRHandler(evt) {
	log.info "event received from RemindR ==> $evt.descriptionText"
    	def children = getChildApps()
        def data = evt.descriptionText
        children.each {child ->
            if (child.label == data) {
            log.info "executing logic block $child.label"
                child.processActions(evt)
            	}
            }
        }
    
def remindRProfiles(evt) {
	def result
    log.warn "received Profiles List from RemindR: $evt.data"
	switch (evt.value) {
		case "refresh":
		state.profiles = evt.jsonData && evt.jsonData?.profiles ? evt.jsonData.profiles : []
			break
		case "runReport":
			def profiles = evt.jsonData
            	result = runReport(profiles)
            break	
    }
    return result
}
/***********************************************************************************************************************
    WEATHER ALERTS
***********************************************************************************************************************/
def verbalWeatherAlerts(){
//	if (getAllAlertsOk() == true) {
//    log.warn "AlertModeOk = $alertModeOk, AlertDaysOk = $alertDaysOk, AlertTimeOk = $alertTimeOk, AlertSwitchesOk = $alertSwitchesOk"
    def pws = getTwcPwsConditions("KALCHELS18")
    log.info "personal is: $pws"
    def currAlert = "There are no weather alerts for your area at this time"
    def weather = getTwcAlerts() 
    log.info "weather is: $weather"
    def alert = weather.headlineText[0]
    def source = weather.source[0]
    alert = alert?.replaceAll(~/ EDT /, " ")?.replaceAll(~/ CDT /, " ")?.replaceAll(~/ MDT /, " ")?.replaceAll(~/ PDT /, " ")
    alert = alert?.replaceAll(~/ SUN /, " Sunday at ")?.replaceAll(~/ MON /, " Monday at ")?.replaceAll(~/ TUE /, " Tuesday at ")
    alert = alert?.replaceAll(~/ WED /, " Wednesday at ")?.replaceAll(~/ THU /, " THursday at ")?.replaceAll(~/ FRI /, " Friday at ")?.replaceAll(~/ SAT /, " Saturday at ")
    alert = alert?.replaceAll(~/ EDT/, " ")?.replaceAll(~/ CDT/, " ")?.replaceAll(~/ MDT/, " ")?.replaceAll(~/ PDT/, " ")
    
    log.info "alert is: $alert"
    if(alert != null) {
        currAlert = "The " + source + " has issued a " + alert + " , I repeat: The " + source + " has issued a " + alert
        return currAlert
    }
    return currAlert
    }
//	if (getAllAlertsOk() == false) {
//		log.warn "A weather alert was issued but was not announced due to your weather alert restrictions"
//    }
//}

// SCHEDULED WEATHER ALERT CHECKS (EVERY 15 MINUTES)
def mGetWeatherAlerts(){
	if (getAllAlertsOk() == true) {
    log.warn "AlertModeOk = $alertModeOk, AlertDaysOk = $alertDaysOk, AlertTimeOk = $alertTimeOk, AlertSwitchesOk = $alertSwitchesOk"
    def tts
    def currAlert
	def weather = getTwcAlerts() 
    def alert = weather.headlineText[0]
    def source = weather.source[0]

    alert = alert?.replaceAll(~/ EDT /, " ")?.replaceAll(~/ CDT /, " ")?.replaceAll(~/ MDT /, " ")?.replaceAll(~/ PDT /, " ")
    alert = alert?.replaceAll(~/ SUN /, " Sunday at ")?.replaceAll(~/ MON /, " Monday at ")?.replaceAll(~/ TUE /, " Tuesday at ")
    alert = alert?.replaceAll(~/ WED /, " Wednesday at ")?.replaceAll(~/ THU /, " THursday at ")?.replaceAll(~/ FRI /, " Friday at ")?.replaceAll(~/ SAT /, " Saturday at ")
    alert = alert?.replaceAll(~/ EDT/, " ")?.replaceAll(~/ CDT/, " ")?.replaceAll(~/ MDT/, " ")?.replaceAll(~/ PDT/, " ")

if (alert != null) {
	if (state.oldAlert == null) {  // New alert issued
		currAlert = "Attention, The " + source + " has issued a " + alert + " , I repeat: The " + source + " has issued a " + alert
        state.oldAlert = "${currAlert}"
   		tts = currAlert
        ttsActions(tts)
        }
	if (state.oldAlert != null) {  // Alert already issued but now has been updated
		currAlert = "Attention, the weather has been updated:  The " + source + " has issued a " + alert + " , I repeat: The " + source + " has issued a " + alert
        if (state.oldAlert != currAlert) {  
        state.oldAlert = "${currAlert}" 
        tts = currAlert
        ttsActions(tts)
        }
        if (state.oldAlert == currAlert) {  // The alert has not changed since the last check
        state.oldAlert = "${currAlert}" 
        def thing = "Unchanged Alert"
        return thing
        }
    }
}

if (alert == null) {
	if (state.oldAlert != null) {  // current alert has been lifted
		currAlert = "Attention, The alert for your area has been lifted, I repeat, the alert for your area has been lifted"
        state.oldAlert = null
		tts = currAlert
        ttsActions(tts)
        }
	if (state.oldAlert == null)  {  // no weather alert
		currAlert = "There are currently no alerts for your area"
        state.oldAlert = null 
		log.info "Line 1 - output should be no alert: $currAlert  & oldAlert is: $state.oldAlert"
        return currAlert
        }
    }    
}
if (getAllAlertsOk() == false) {
	log.warn "A weather alert was issued but was not announced due to your weather alert restrictions"
    }
}
/******************************************************************************
	 FEEDBACK SUPPORT - ADDITIONAL FEEDBACK	
     
                        data.deviceTypeDoors = "cDoor1"
                        data.deviceTypeWindows = "cWindow"
                        data.deviceDoors = devListDoors
                        data.deviceWindows = devListWindows
                        state.lastAction = data
                        state.pContCmdsR = "feedback"
    
******************************************************************************/
def getMoreFeedback(data) {
    def devices = data.devices
    def deviceType = data.deviceType
    def deviceDoors = data.deviceDoors
    def deviceTypeDoors = data.deviceTypeDoors
    def deviceWindows = data.deviceWindows
    def deviceTypeWindows = data.deviceTypeWindows
    def command = data.cmd
    def outputTxt = ""
	if ( deviceType == "cSwitch") {
    	outputTxt = "The following lights are " + command + "," + devices.sort().unique()
    }
	if ( deviceType == "cDoor1") {    // Added by Jason to ask "are doors open" on 2/27/2017
    	if (devices?.size() == 1) {
    	outputTxt = "The following door, " + devices + " is " + command 
        }
        else if (devices?.size() > 1) { 
        outputTxt = "The following doors are " + command + "," + devices.sort().unique()
    	}
    }
	if (deviceType == "cWindow") {    // Added by Jason to ask "are doors open" on 2/27/2017
    	if (devices?.size() == 1) {
    	outputTxt = " The following window, " + devices + " is " + command 
    	}
        else { 
        outputTxt = "The following windows are " + command + "," + devices.sort().unique()
    	}
    }
    if ( deviceTypeDoors == "cDoor1" && deviceTypeWindows == "cWindow") {
    	if (data.deviceTypeWindows?.size() == 0 && data.deviceTypeDoors?.size() == 1) {
        	outputTxt = "The following door is " + command + "," + deviceTypeDoors.sort().unique()
            }
    	if (data.deviceTypeWindows?.size() == 1 && data.deviceDoors?.size() == 0) {
            outputTxt = "The following window is " + command + "," + deviceTypeWindows.sort().unique()
            }
        if (data.deviceTypeWindows?.size() == 0 && data.deviceDoors?.size() > 0) {
        	outputTxt = "The following doors are " + command + "," + deviceTypeDoors.sort().unique()
            }
    	else if (data.deviceTypeWindows?.size() > 1 && data.deviceDoors?.size() == 0) { 
            outputTxt = "The following windows are " + command + "," + deviceTypeWindows.sort().unique()
            }
        else if (data.deviceTypeWindows?.size() > 0 && data.deviceDoors?.size() > 0) {    
            outputTxt = "The following doors are " + command + "," + deviceDoors.sort().unique() + " , and the following windows are " + command + "," + deviceWindows.sort().unique() 
   			}
    state.pContCmdsR = null 
	state.lastAction = null
	}
//    return ["outputTxt":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN]	

	return outputTxt  //":outputTxt, "pContCmds":state.pContCmds, "pShort":state.pShort, "pContCmdsR":state.pContCmdsR, "pTryAgain":state.pTryAgain, "pPIN":pPIN	
}    