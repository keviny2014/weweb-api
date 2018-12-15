package com.weweb;

import com.weweb.common.entity.CodeMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * http://localhost:8080/swagger-ui.html Created by jackshen on 2017/4/3.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).useDefaultResponseMessages(false)
				.globalOperationParameters(requestParameters())
				.globalResponseMessage(RequestMethod.GET, responseMessage())
				.globalResponseMessage(RequestMethod.POST,responseMessage()).select()
				.apis(RequestHandlerSelectors.basePackage("com.weweb.api")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Weweb api document").description("This is weweb api")
				.termsOfServiceUrl("http://www.xxxx.com").version("1.0").build();
	}

	private List<ResponseMessage> responseMessage() {
		List<ResponseMessage> responseMessages = new ArrayList<>();
		responseMessages.add(new ResponseMessageBuilder().code(Integer.parseInt(CodeMessage.SERVER_ERROR.getCode())).message(CodeMessage.SERVER_ERROR.getMessage()).build());
		responseMessages.add(new ResponseMessageBuilder().code(Integer.parseInt(CodeMessage.OPERATE_FAIL.getCode())).message(CodeMessage.OPERATE_FAIL.getMessage()).build());
		responseMessages.add(new ResponseMessageBuilder().code(Integer.parseInt(CodeMessage.INVALIDTOKEN.getCode())).message(CodeMessage.INVALID_PARAMETER.getMessage()).build());
        responseMessages.add(new ResponseMessageBuilder().code(Integer.parseInt(CodeMessage.UNAUTHUSER.getCode())).message(CodeMessage.UNAUTHUSER.getMessage()).build());
        return responseMessages;
	}
	private List<Parameter> requestParameters(){
		List<Parameter> parameters=new ArrayList<>();
		Parameter parameter=new ParameterBuilder()
				.name("app_token")
				.description("token after user logon")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(true)
				.build();

		Parameter parameter2=new ParameterBuilder()
				.name("dev_os_type")
				.description("android is 0,iOS is 1").defaultValue("0")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(true)
				.build();
		parameters.add(parameter);
		parameters.add(parameter2);
		return parameters;
	}
}