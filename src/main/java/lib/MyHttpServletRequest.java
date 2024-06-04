/*
 * DuyDuc94
 */
package lib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author duy20
 */
public class MyHttpServletRequest extends HttpServletRequestWrapper {

    private String method;

    public MyHttpServletRequest(HttpServletRequest request, String method) {
        super(request);
        this.method = method;
    }

    @Override
    public String getMethod() {
        return method;
    }
}
