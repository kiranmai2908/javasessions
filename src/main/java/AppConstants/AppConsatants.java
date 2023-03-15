package AppConstants;

import java.util.Arrays;
import java.util.List;

public class AppConsatants {
	
	public static final int DEFAULT_MEDIUM_TIME_OUT=10;
	public static final int DEFAULT_SHORT_TIME_OUT=5;
	public static final int DEFAULT_LONG_TIME_OUT=15;
	
	public static final String LOGIN_PAGE_TITLE_VALUE="Account Login";
	public static final String LOGIN_PAGE_URL_FRACTIONVALUE="route=account/login";
	public static final String ACCOUNTS_PAGE_URL_FRACTIONVALUE="route=account/account";
	public static final String ACCOUNTS_PAGE_URL_VALUE="https://naveenautomationlabs.com/opencart/index.php?route=account/account";
	public static final String LOGIN_PAGE_PAGE_URL_VALUE="https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static final int ACCOUNTS_PAGE_HEADERS_COUNT=4;
	public static final List<String> EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST=Arrays.asList("My Orders","My Account","My Affiliate Account","Newsletter");
	public static final String ACCOUNT_PAGE_TITLE_VALUE="My Account";
}
