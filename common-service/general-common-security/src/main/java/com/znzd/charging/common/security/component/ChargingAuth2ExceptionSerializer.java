

package com.znzd.charging.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.znzd.charging.common.core.constant.CommonConstants;
import com.znzd.charging.common.security.exception.ChargingAuth2Exception;

import java.io.IOException;

/**
 * @author zhoupeilong
 * @date 2018/11/16
 * <p>
 * OAuth2 异常格式化
 */
public class ChargingAuth2ExceptionSerializer extends StdSerializer<ChargingAuth2Exception> {
	public ChargingAuth2ExceptionSerializer() {
		super(ChargingAuth2Exception.class);
	}

	@Override
	public void serialize(ChargingAuth2Exception value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeObjectField("code", CommonConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}
}
