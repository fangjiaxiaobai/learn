# SpringSecurity 

身份信息的存放容器SecurityContextHolder，身份信息的抽象Authentication，
身份认证器AuthenticationManager及其认证流程。



# SpringSecurity 身份认证流程

1.用户提交用户名和密码,被过滤器拦截，封装成Authentication(其实现类，一般为UsernamePasswordAuthenticationToken)。

2 AuthenticationManager 身份管理器负责验证这个Authentication

3 认证成功后，AuthenticationManager身份管理器返回一个被填充满了信息的（包括上面提到的权限信息，身份信息，细节信息，但密码通常会被移除）Authentication实例。

4 SecurityContextHolder安全上下文容器将第3步填充了信息的Authentication，通过SecurityContextHolder.getContext().setAuthentication(…)方法，设置到其中。

先看：Authentication这个是登录用户的信息的封装，
    SecurityContextHolder: Security上下文。
    将要登录的用户信息会被封装到UsernamePasswordAuthenticationToken中。
    由AuthenticattionManager 委托给 AuthenticationProvider去真正的认证操作。
   例如： AuthenticationManager的实现类ProviderManager,内部维护了多个AuthenticationProvider的集合，去认证。


接下来的是：
    AuthenticationProvider的具体实现：
    1.DaoAuthenticationProvider:
    
