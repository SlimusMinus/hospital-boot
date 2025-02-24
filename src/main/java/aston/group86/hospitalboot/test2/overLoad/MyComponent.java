package aston.group86.hospitalboot.test2.overLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MyComponent {

  @Autowired
  private MyComponent self;

  @Transactional
  void methodB() {
    methodC();
  }

  @Transactional
  void methodC() {
    //..
  }

}
