package com.entropy.backend.common;

import com.entropy.backend.common.constants.APIEndpointBase;
import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.common.constants.AppConstant;
import com.entropy.backend.common.utils.CookieUtil;
import com.entropy.backend.common.utils.EmailUtil;
import com.entropy.backend.common.utils.SystemUtil;
import com.entropy.backend.common.utils.TimeUtil;

/**
 * @author bac-ta
 */
public class App {
    public static class ApiMessage extends APIMessage {

    }

    public static class ApiEndpointBase extends APIEndpointBase {

    }

    public static class Constant extends AppConstant {

    }

    public static class System extends SystemUtil {

    }

    public static class Cookie extends CookieUtil {

    }

    public static class Email extends EmailUtil {

    }

    public static class Time extends TimeUtil {

    }
}
