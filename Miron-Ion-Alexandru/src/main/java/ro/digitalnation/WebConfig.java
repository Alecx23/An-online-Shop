package ro.digitalnation;

import java.io.File;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	String UPLOAD_DIRECTORY = System.getProperty("user.dir")+File.separator + "src" + File.separator
			+"main" +File.separator+"resources"+File.separator+"static"+File.separator+"uploads";
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + UPLOAD_DIRECTORY + File.separator);
    }
}
