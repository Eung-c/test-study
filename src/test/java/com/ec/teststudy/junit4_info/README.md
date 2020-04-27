# Junit 4

## 목차

- Junit
- @Test
- @BeforeClass, @AfterClass, @Before, @After
- 예외처리 테스트
- 시간 제한 테스트
- @RunWith
- @SuiteClasses

---

## 1. Junit 특징

Test 프레임워크

1.1. 제공하는 기능들

* 테스트 결과가 예상과 같은지를 판별해주는 단정문(assertions)
* 여러 테스트에서 공용으로 사용할 수 있는 테스트 픽스처(test fixture)
* 테스트 작업을 수행할 수 있게 해주는 테스트 러너(test runner)

1.2. 테스트 픽스처란?

* 기반이 되는 상태나 환경
* 일괄된 테스트 실행환경
* ex) 공통으로 사용되는 객체를 생성
* ex) 테스트 앞뒤로 특정 작업을 수행함
  <br><br>

1.3. 테스트 케이스? 테스트 메소드?

* 케이스 -> 시나리오 성격이 강함
* 메소드 -> JUnit 메소드
* 그냥 동일하다고 생각하고 사용

1.4. JUnit4 특징

* Java 5 애노테이션 지원
    * @Test 를 붙여 test 메소드라는것을 명시
* JUnit3 의 method 제약 해소 -> 접두사가 test일 필요가 없음
* 좀 더 유여한 픽스처
* 예외 테스트
    * @Before, @After, @BeforeClass, @AfterClass
* 시간 제한 테스트
    * @Test(timeout=1000)
* 테스트 무시
    * @Ignore("이 메소드는 작동하지 않음")
* 배열 지원
    * assertArrayEquals()
* @RunWith(클래스이름.class)
    * 사용하고 싶은 Runner 를 명시적으로 지정
* @SuiteClasses
    * 여러개의 테스트 클래스 동시 실행 가능


## 2. 기능들
### @Test
```java
@Test // 테스트 대상 메소드에 표시
public void testDeposit() {
    account.deposit(1000);
    assertEquals(11000, account.getBalance());
}
```
### 테스트 픽스처 메소드 추가 지원
```java

public class AccountTest {

    @BeforeClass
    public static void initAccountClass(){
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void endAccountClass(){
        System.out.println("AfterClass");
    }

    @Before
    public void initAccount(){
        System.out.println("Before");
    }

    @After
    public void endAccount(){
        System.out.println("After");
    }
    
    @Test
    public void testMethod(){
        /* assert... */
        System.out.println("Test");
    }
}


>>> BeforeClass
>>> Before
>>> Test
>>> After
>>> AfterClass

```

### 예외 테스트
```java
@Test (expected=NumberFormatException.class) // 예상되는 예외를 표시
    public void testException(){
    String value = "a1234";
    System.out .println(Integer.parseInt(value));
} // -> 테스트 성공
```

### 테스트 시간 제한
```java
@Test(timeout=5000) // 시간 설정
public void testTimer() {
    timerService.ticktock();
    assertEquals(TimerStatus.FAIL, timerService.getState());
} // -> 정해진 시간안에 메소드가 수행 완료 되지 않으면 실패
```

### 테스트 무시
```java
@Ignore
@Test
public void testA() {
    assertTrue (serviceA.isValid());
} // -> 테스트 무시 
```

### 배열 지원
```java
@Test
public void testArrayAssertEquals() {
    String [] names = {"Tom", "JIMMY", "JOHIN"};
    String [] anotherNames = {"Tom", "JIMMY", "JOHIN"};
    assertArrayEquals (names, anotherNames);
} // 순서는 보장 안함
```

### @RunWith
* 테스트 메소드 실행을 담당하는 클래스를 테스트 러너(Test Runner) 라고 함
* 기본적인 JUnit 러너는 BlockJUnit4ClassRunner.class
* 해당 Runner를 변경하고 싶으면 명시적으로 표시
* 예를 들어 스프링 프레임워크에서는 SpringJUnit4ClassRunner.class 를 지원 -> 스프링에 맞는 확장된 기능을 사용해 테스트 가능

### @SuiteClasses
* 여러개의 테스트를 일괄적으로 수행
```java
    // ATest.class, BTest.class, CTest.class 를 통시해 테스트 가능
    @RunWith(Suite.class)
    @SuiteClasses(ATest.class, BTest.class, CTest.class)
    public class ABCSuite {
    }
```