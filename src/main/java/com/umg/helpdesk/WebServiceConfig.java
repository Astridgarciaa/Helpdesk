package com.umg.helpdesk;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "usuarios")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema usuariosSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UsuariosPort");
        wsdl11Definition.setLocationUri("/ws/usuarios");
        wsdl11Definition.setTargetNamespace("http://umg.com/soapservice");
        wsdl11Definition.setSchema(usuariosSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema usuariosSchema() {
        return new SimpleXsdSchema(new ClassPathResource("usuarios.xsd"));
    }

    @Bean(name = "empleados")
    public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema empleadosSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EmpleadosPort");
        wsdl11Definition.setLocationUri("/ws/empleados");
        wsdl11Definition.setTargetNamespace("http://umg.com/soapservice");
        wsdl11Definition.setSchema(empleadosSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema empleadosSchema() {
        return new SimpleXsdSchema(new ClassPathResource("empleados.xsd"));
    }

    @Bean(name = "empresas")
    public DefaultWsdl11Definition defaultWsdl11Definition3(XsdSchema empresasSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EmpresasPort");
        wsdl11Definition.setLocationUri("/ws/empresas");
        wsdl11Definition.setTargetNamespace("http://umg.com/soapservice");
        wsdl11Definition.setSchema(empresasSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema empresasSchema() {
        return new SimpleXsdSchema(new ClassPathResource("empresas.xsd"));
    }
}

