package se.payerl.projectorcontroller.benq;

public class Generic {
	public class Power {
		public static final String ON = "\r*pow=on#\r";
		public static final String OFF = "\r*pow=off#\r";
		public static final String CHECK = "\r*pow=?#\r";
	}
	
	public class SourceSelection {
		public static final String COMPUTER_YPbPr = "\r*sour=RGB#\r";
		public static final String COMPUTER2_YPbPr2 = "\r*sour=RGB2#\r";
		public static final String COMPONENT = "\r*sour=ypbr#\r";
		public static final String COMPONENT2 = "\r*sour=ypbr2#\r";
		public static final String DVI_A = "\r*sour=dviA#\r";
		public static final String DVI_D = "\r*sour=dvid#\r";
		public static final String HDMI = "\r*sour=hdmi#\r";
		public static final String HDMI2 = "\r*sour=hdmi2#\r";
		public static final String COMPOSITE = "\r*sour=vid#\r";
		public static final String S_VIDEO = "\r*sour=svid#\r";
		public static final String NETWORK = "\r*sour=network#\r";
		public static final String USB_DISPLAY = "\r*sour=usbdisplay#\r";
		public static final String USB_READER = "\r*usbreader#\r";
		public static final String CHECK = "\r*sour=?#\r";
	}
	
	public class AudioControl {
		public class Mute {
			public static final String ON = "\r*mute=on#\r";
			public static final String OFF = "\r*mute=off#\r";
			public static final String CHECK = "\r*mute=?#\r";
		}
		public class Volume {
			public static final String INCREASE = "\r*vol=+#\r";
			public static final String DECREASE = "\r*vol=-#\r";
			public static final String CHECK = "\r*vol=?#\r";
		}
		public class Microphone {
			public static final String INCREASE = "\r*micvol=+#\r";
			public static final String DECREASE = "\r*micvol=-#\r";
			public static final String CHECK = "\r*micvol=?#\r";
		}
	}
	
	public class AudioSourceSelect {
		public static final String PASS_THROUGH_OFF = "\r*audiosour=off#\r";
		public static final String COMPUTER1 = "\r*audiosour=RGB#\r";
		public static final String COMPUTER2 = "\r*audiosour=RGB2#\r";
		public static final String AUDIO_VIDEO__S_VIDEO = "\r*audiosour=vid#\r";
		public static final String COMPONENT = "\r*audiosour=ypbr#\r";
		public static final String HDMI = "\r*audiosour=hdmi#\r";
		public static final String HDMI2 = "\r*audiosour=hdmi2#\r";
		public static final String PASS_CHECK = "\r*audiosour=?#\r";
	}
	
	public class PictureMode {
		public static final String DYNAMIC = "\r*appmod=dynamic#\r";
		public static final String PRESENTATION = "\r*appmod=preset#\r";
		public static final String SRGB = "\r*appmod=srgb#\r";
		public static final String BRIGHT = "\r*appmod=bright#\r";
		public static final String LIVING_ROOM = "\r*appmod=livingroom#\r";
		public static final String GAME = "\r*appmod=game#\r";
		public static final String CINEMA = "\r*appmod=cine#\r";
		public static final String STANDARD = "\r*appmod=std#\r";
		public static final String USER1 = "\r*appmod=user1#\r";
		public static final String USER2 = "\r*appmod=user2#\r";
		public static final String USER3 = "\r*appmod=user3#\r";
		public static final String ISF_DAY = "\r*appmod=isfday#\r";
		public static final String ISF_NIGHT = "\r*appmod=isfnight#\r";
		public static final String _3D = "\r*appmod=threed#\r";
		public static final String CHECK = "\r*appmod=?#\r";
	}
	
	public class PictureSetting {
		public class Contrast {
			public static final String INCREASE = "\r*con=+#\r";
			public static final String DECREASE = "\r*con=-#\r";
			public static final String CHECK = "\r*con=?#\r";
		}
		
		public class Brightness {
			public static final String INCREASE = "\r*bri=+#\r";
			public static final String DECREASE = "\r*bri=-#\r";
			public static final String CHECK = "\r*bri=?#\r";
		}
		
		public class Color {
			public static final String INCREASE = "\r*color=+#\r";
			public static final String DECREASE = "\r*color=-#\r";
			public static final String CHECK = "\r*color=?#\r";
		}
		
		public class Sharpness {
			public static final String INCREASE = "\r*sharp=+#\r";
			public static final String DECREASE = "\r*sharp=-#\r";
			public static final String CHECK = "\r*sharp=?#\r";
		}
		
		public class ColorTemperature {
			public static final String WARMER = "\r*ct=warmer#\r";
			public static final String WARM = "\r*ct=warm#\r";
			public static final String NORMAL = "\r*ct=normal#\r";
			public static final String COOL = "\r*ct=cool#\r";
			public static final String COOLER = "\r*ct=cooler#\r";
			public static final String LAMP_NATIVE = "\r*ct=native#\r";
			public static final String CHECK = "\r*ct=?#\r";
		}
		
		public class Aspect {
			public static final String A_4_3 = "\r*asp=4:3#\r";
			public static final String A_16_9 = "\r*asp=16:9#\r";
			public static final String A_16_10 = "\r*asp=16:10#\r";
			public static final String A_AUTO = "\r*asp=AUTO#\r";
			public static final String A_REAL = "\r*asp=REAL#\r";
			public static final String A_LETTERBOX = "\r*asp=LBOX#\r";
			public static final String A_WIDE = "\r*asp=WIDE#\r";
			public static final String A_ANAMORPHIC = "\r*asp=ANAM#\r";
			public static final String A_CHECK = "\r*asp=?#\r";
		}
		
		public class DigitalZoom {
			public static final String IN = "\r*zoomI#\r";
			public static final String OUT = "\r*zoomO#\r";
		}
		
		public static final String AUTO = "\r*auto#\r";
		
		public class BrilliantColor {
			public static final String ON = "\r*BC=on#\r";
			public static final String OFF = "\r*BC=off#\r";
			public static final String CHECK = "\r*BC=?#\r";
		}
	}
	
	public class OperationSettings {
		public class ProjectorPosition {
			public static final String FRONT_TABLE = "\r*pp=FT#\r";
			public static final String REAR_TABLE = "\r*pp=RE#\r";
			public static final String REAR_CEILING = "\r*pp=RC#\r";
			public static final String FRONT_CEILING = "\r*pp=FC#\r";
			public static final String CHECK = "\r*pp=?#\r";
		}
		
		public class QuickAutoSearch {
			public static final String ON = "\r*QAS=on#\r";
			public static final String OFF = "\r*QAS=off#\r";
			public static final String CHECK = "\r*QAS=?#\r";
		}
		
		public class DirectPower {
			public static final String ON = "\r*directpower=on#\r";
			public static final String OFF = "\r*directpower=off#\r";
			public static final String CHECK = "\r*directpower=?#\r";
		}
		
		public class SignalPower {
			public static final String ON = "\r*autopower=on#\r";
			public static final String OFF = "\r*autopower=off#\r";
			public static final String CHECK = "\r*autopower=?#\r";
		}
		
		public class StandbySettings {
			public class Network {
				public static final String ON = "\r*standbynet=on#\r";
				public static final String OFF = "\r*standbynet=off#\r";
				public static final String CHECK = "\r*standbynet=?#\r";
			}
			
			public class Microphone {
				public static final String ON = "\r*standbymic=on#\r";
				public static final String OFF = "\r*standbymic=off#\r";
				public static final String CHECK = "\r*standbymic=?#\r";
			}
			
			public class MonitorOut {
				public static final String ON = "\r*standbymnt=on#\r";
				public static final String OFF = "\r*standbymnt=off#\r";
				public static final String CHECK = "\r*standbymnt=?#\r";
			}
		}
	}
	
	public class BaudRate {
		public static final String BAUD_2400 = "\r*baud=2400#\r";
		public static final String BAUD_4800 = "\r*baud=4800#\r";
		public static final String BAUD_9600 = "\r*baud=9600#\r";
		public static final String BAUD_14400 = "\r*baud=14400#\r";
		public static final String BAUD_19200 = "\r*baud=19200#\r";
		public static final String BAUD_38400 = "\r*baud=38400#\r";
		public static final String BAUD_57600 = "\r*baud=57600#\r";
		public static final String BAUD_115200 = "\r*baud=115200#\r";
		public static final String CHECK = "\r*baud=?#\r";
	}
	
	public class LampControl {
		public static final String LAMP_HOUR = "\r*ltim=?#\r";
		public static final String LAMP2_HOUR = "\r*ltim2=?#\r";
		
		public class Mode {
			public static final String NORMAL = "\r*lampm=lnor#\r";
			public static final String ECO = "\r*lampm=eco#\r";
			public static final String SMART_ECO = "\r*lampm=seco#\r";
			public static final String DUAL_BRIGHTEST = "\r*lampm=dualbr#\r";
			public static final String DUAL_RELIABLE = "\r*lampm=dualre#\r";
			public static final String SINGLE_ALTERNATIVE = "\r*lampm=single#\r";
			public static final String SINGLE_ALTERNATIVE_ECO = "\r*lampm=singleeco#\r";
			public static final String CHECK = "\r*lampm=?#\r";
		}
	}
	
	public class Miscellaneous {
		public static final String MODEL_NAME = "\r*modelname=?#\r";
		
		public class Blank {
			public static final String ON = "\r*blank=on#\r";
			public static final String OFF = "\r*blank=off#\r";
			public static final String CHECK = "\r*blank=?#\r";
		}
		
		public class Freeze {
			public static final String ON = "\r*freeze=on#\r";
			public static final String OFF = "\r*freeze=off#\r";
			public static final String CHECK = "\r*freeze=?#\r";
		}
		
		public class Menu {
			public static final String ON = "\r*menu=on#\r";
			public static final String OFF = "\r*menu=off#\r";
		}

		public static final String UP = "\r*up#\r";
		public static final String DOWN = "\r*down#\r";
		public static final String RIGHT = "\r*right#\r";
		public static final String LEFT = "\r*left#\r";
		public static final String ENTER = "\r*enter#\r";
		
		public class _3D {
			public static final String SYNC_OFF = "\r*3d=off#\r";
			public static final String AUTO = "\r*3d=auto#\r";
			public static final String SYNC_TOP_BOTTOM = "\r*3d=tb#\r";
			public static final String FRAME_SEQUENTIAL = "\r*3d=fs#\r";
			public static final String FRAME_PACKING = "\r*3d=fp#\r";
			public static final String SIDE_BY_SIDE = "\r*3d=sbs#\r";
			public static final String INVERTER_DISABLE = "\r*3d=da#\r";
			public static final String INVERTER = "\r*3d=iv#\r";
			public static final String _2D_TO_3D = "\r*3d=2d3d#\r";
			public static final String nVIDIA = "\r*3d=nvidia#\r";
			public static final String CHECK = "\r*3d=?#\r";
		}
		
		public class RemoteReceiver {
			public static final String FRONT_AND_REAR = "\r*rr=fr#\r";
			public static final String FRONT = "\r*rr=f#\r";
			public static final String REAR = "\r*rr=r#\r";
			public static final String CHECK = "\r*rr=?#\r";
		}
		
		public class InstantOn {
			public static final String ON = "\r*ins=on#\r";
			public static final String OFF = "\r*ins=off#\r";
			public static final String CHECK = "\r*ins=?#\r";
		}
		
		public class LampSaverMode {
			public static final String ON = "\r*lpsaver=on#\r";
			public static final String OFF = "\r*lpsaver=off#\r";
			public static final String CHECK = "\r*lpsaver=?#\r";
		}
		
		public class ProjectionLogInCode {
			public static final String ON = "\r*prjlogincode=on#\r";
			public static final String OFF = "\r*prjlogincode=off#\r";
			public static final String CHECK = "\r*prjlogincode=?#\r";
		}
		
		public class Broadcasting {
			public static final String ON = "\r*broadcasting=on#\r";
			public static final String OFF = "\r*broadcasting=off#\r";
			public static final String CHECK = "\r*broadcasting=?#\r";
		}
		
		public class AmxDeviceDiscovery {
			public static final String ON = "\r*amxdd=on#\r";
			public static final String OFF = "\r*amxdd=off#\r";
			public static final String CHECK = "\r*amxdd=?#\r";
		}
		
		public static final String MAC_ADDRESS = "\r*macaddr=?#\r";
		
		public class HighAltitudeMode {
			public static final String ON = "\r*Highaltitude=on#\r";
			public static final String OFF = "\r*Highaltitude=off#\r";
			public static final String CHECK = "\r*Highaltitude=?#\r";
		}
	}
}