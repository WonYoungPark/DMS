//package com.gvalley.dms.com.aop;
//
//
///**
//* Some descriptions here.
//*
//* @aothor WonYoungPark / wyparks2@gmail.com
//* @Date 2016. 2. 10.
//* @since 0.1
//*/
//public class UserSessionInterceptor extends HandlerInterceptorAdapter {
//    private ConnectionRepository connectionRepository;
//
//    public UserSessionInterceptor(ConnectionRepository connectionRepository) {
//            this.connectionRepository = connectionRepository;
//    }
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
//
//        if (connection != null) {
//            ConnectionData data = connection.createData();
//
//            request.setAttribute("user",
//                                 new UserSession(data.getProviderUserId(), data.getImageUrl(), data.getDisplayName()));
//        }
//
//        return true;
//    }
//}
