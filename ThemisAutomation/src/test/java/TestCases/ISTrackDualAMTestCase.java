package TestCases;

import org.apache.log4j.Logger;

import themis.Pages.AllWorkPage;
import themis.Pages.CreateCasePage;
import themis.Pages.GoldOrderPage;
import themis.Pages.GuardianHomePage;
import themis.Pages.GuardianLoginPage;
import themis.Pages.ISTrackLoginPage;
import themis.Pages.MyGroupPage;
import themis.Pages.MyWorkPage;
import themis.Pages.OFPage;
import themis.Pages.ORPage;
import themis.Pages.OTPage;
import themis.Pages.TaskCompletionPage;
import themis.TestBase.TestBase;
import themis.Util.AutoGenerateMail;

public class ISTrackDualAMTestCase extends TestBase {
	
	public static final Logger log = Logger.getLogger(ISTrackDualAMTestCase.class.getName());
	
	ISTrackLoginPage istrackloginpage;
	CreateCasePage createcasepage;
	ORPage orpage;
	OFPage ofpage;
	AllWorkPage allworkpage;
	MyWorkPage myworkpage;
	TaskCompletionPage taskcompletionpage;
	GoldOrderPage goldorderpage;
	MyGroupPage mygrouppage;
	GuardianLoginPage guardianloginpage;
	GuardianHomePage guardianhomepage;
	AutoGenerateMail autogeneratemail;
	OTPage otpage;
	
	public ISTrackDualAMTestCase()
	{
		super();
	}
	
	
	

}
