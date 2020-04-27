/*
 * ******************************************************************************
 *  * Copyright 2020 (C) N*able
 *  * @author Roshan Wijendra
 *  ******************************************************************************
 */
package biz.nable.sb.cor.commission.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author roshanw
 *
 */

public class JsonLoader {

	public Object loadObject(String fileName, Class<?> objectClass) throws JSONException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
		return mapper.readValue(in, objectClass);
	}
}
