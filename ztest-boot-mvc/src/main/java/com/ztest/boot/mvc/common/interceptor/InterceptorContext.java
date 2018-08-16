package com.ztest.boot.mvc.common.interceptor;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/6 0006 19
 */
public class InterceptorContext {

    private static final ThreadLocal<RequestLog> logLocal = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            RequestLog requestLog = new RequestLog();
            requestLog.setRequestTime(System.currentTimeMillis());
            return requestLog;
        }
    };

    public static RequestLog getLog() {
        return logLocal.get();
    }

    public static class RequestLog {
        private Long requestTime;
        private Long requestId;

        public Long getRequestTime() {
            return requestTime;
        }

        public void setRequestTime(Long requestTime) {
            this.requestTime = requestTime;
        }

        public Long getRequestId() {
            return requestId;
        }

        public void setRequestId(Long requestId) {
            this.requestId = requestId;
        }
    }
}
