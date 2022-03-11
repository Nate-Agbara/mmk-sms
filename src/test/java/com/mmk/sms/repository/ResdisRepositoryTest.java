//package com.mmk.sms.repository;
//
//import com.mmk.sms.domain.SMSDomain;
//import com.mmk.sms.redisconfig.RedisConfig;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//
///**
// * @author: Nathan
// */
////@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
////@SpringBootTest(classes = TestRedisConfiguration.class)
//public class ResdisRepositoryTest {
//
//    @Autowired
//    private RedisRepository redisRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    public void savedKeyTest_returnsSavedKey() {
//        //given
////        SMSDomain smsDomain = SMSDomain.builder().id("1").to("123456").from("654321").build();
////        //when
////        entityManager.persist(smsDomain);
////        Optional<SMSDomain> smsDomainOptional = redisRepository.findById(smsDomain.getId());
////
////        //then
////        assertThat(smsDomainOptional.get().getFrom(), is("654321"));
//    }
//}
