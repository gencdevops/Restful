When I try to deploy this project into Glassfish 4.12 it kept giving following error:

java.lang.Exception: java.lang.IllegalStateException: ContainerBase.addChild: start: org.apache.catalina.LifecycleException: java.lang.NoClassDefFoundError: org/apache/AnnotationProcessor

Then ı downloaded following jar file and add it into its lib directory under WEB_INF and it got resolved.

tomcat-6.0.33.jasper.jar