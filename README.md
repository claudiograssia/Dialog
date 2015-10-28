# Dialog

This is a JAVAFX Dialog for java 8

Download project and compile

For message info
```java
Dialog d = Dialog.newInstance();
d.info("Message info");
d.show();
```

For message warning
```java
Dialog d = Dialog.newInstance();
d.warning("Message warning");
d.show();
```

For message error
```java
Dialog d = Dialog.newInstance();
d.error("Message error");
d.show();
```
For message confirm
```java
Dialog d = Dialog.newInstance();
d.confirm(null, null, "Message confirm");
d.confirm(
  okEvent -> {
    //{other code for btn ok}
  },
  noEvent -> {
    //{other code for btn no}
  },
  "message for confirm"
);
d.show();
```


