# 테스트 코드를 작성함으로써 얻는 이점

* [위키피디아 설명](https://en.wikipedia.org/wiki/Unit_testing)

* 단위 테스트는 개발단계 초기에 문제를 발견하게 도와줍니다.
* 단위 테스트는 개발자가 나중에 코드를 리팩토링하나 라이브러리 업그레이드 등에서 기존 기능이 올바르게 작동하는지 확인할 수 있습니다.
* 단위 테스트는 기능에 대한 불확실성을 감소시킬 수 있습니다.
* 단위 테스트는 시스템에 대한 실제 문서를 제공합니다. 즉, 단위 테스트 자체가 문서로 사용될 수 있습니다.

# 빠른 피드백

## 테스트가 없는 개발 방식
1. 코드 작성
2. 서버 가동
3. [Postman](https://www.postman.com/) 과 같은 API 테스트 도구로 HTTP 요청
4. 요청 결과를 Loggin 또는 디버깅을 통해 눈으로 검증
5. 결과가 다르면 수정

## 테스트가 없는 개발 방식 문제점
* 위 방식에서는 2~5번을 코드가 수정될 때 마다 반복해야함
* 빌드가 오래 걸린다면 작은 기능 하나 수정할때도 많은 시간이 걸림
* 사람이 로깅을 통해 눈으로 검증해야 함
* 수정이 다른 코드에 미치는 영향도 파악이 힘듬


## 실습내용
* HelloControllerTest 돌려보기