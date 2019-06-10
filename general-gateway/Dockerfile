FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER znzpl@znstchina.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /charging-gateway

WORKDIR /charging-gateway

EXPOSE 9999

ADD ./charging-gateway/target/charging-gateway.jar ./

CMD java -Djava.security.egd=file:/dev/./urandom -jar charging-gateway.jar
