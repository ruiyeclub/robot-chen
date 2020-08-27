# Docker image for springboot file run
# VERSION 0.0.1
# Author: Ray
# 基础镜像使用java
FROM java:8
# 作者
MAINTAINER Ray <185048761@qq.com>
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名为rebot-web.jar
ADD rebot-web.jar rebot-web.jar
# 运行jar包
RUN bash -c 'touch /rebot-web.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/rebot-web.jar"]
#暴露8081端口
EXPOSE 8081