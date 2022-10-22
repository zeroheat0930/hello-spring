package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {


    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }


//    private final DataSource dataSource;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
//    @Bean
//    public MemberRepository memberRepository() {
// return new MemoryMemberRepository(); //그냥 DB연동전에 임시로 스프링안에서 굴리도록 사용
//        return new JdbcMemberRepository(dataSource); //순수JDBC 사용
//       return new JdbcTemplateMemberRepository(dataSource); //jdbc template 사용
//        return new JpaMemberRepository(em); //jpa사용
    // 그후 jpa + 스프링데이터는 인터페이스에서 다 알아서 해줘서 repository 필요가없음
//    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();   //컴포넌트 스캔 쓰면 쓸필요없음
//    }

}
