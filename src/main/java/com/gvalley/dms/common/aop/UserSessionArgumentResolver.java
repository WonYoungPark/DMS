//package com.gvalley.dms.com.aop;
//
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//
//public class UserSessionArgumentResolver implements HandlerMethodArgumentResolver {
//
//    private ConnectionRepository connectionRepository;
//
//    public UserSessionArgumentResolver(ConnectionRepository connectionRepository) {
//            this.connectionRepository = connectionRepository;
//    }
//
//    @Override
//    public boolean supportsParameter(MethodParameter parameter) {
//            return UserSession.class.isAssignableFrom(parameter.getParameterType());
//    }
//
//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
//                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
//        if (connection == null) {
//                return null;
//        }
//        ConnectionData data = connection.createData();
//        return new UserSession(data.getProviderUserId(), data.getImageUrl(), data.getDisplayName());
//    }
//}
