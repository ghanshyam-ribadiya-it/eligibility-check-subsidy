package com.eligibility.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class EligibilityConfiguration {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(applicationContext);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(messageDispatcherServlet, "/service/*");
	}

	@Bean(name = "usereligibility")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema eligibilitySchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("UserEligibilityPort");
		wsdl11Definition.setLocationUri("/service/user-detail");
		wsdl11Definition.setTargetNamespace("http://www.usereligibility.com/xml/payload");
		wsdl11Definition.setSchema(eligibilitySchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema eligibilitySchema() {
		return new SimpleXsdSchema(new ClassPathResource("usereligibility.xsd"));
	}

}
