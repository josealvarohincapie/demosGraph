package com.studytrails.json.gson;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class ParseTokenExample7
{
	public static void main(String[] args) throws MalformedURLException, IOException
	{
		String token = "eyJ0eXAiOiJKV1QiLCJub25jZSI6InU1TUNuRW1UYlZFUWNHd1J0dXJwNUZQekpOZ05lMXN2Sk95UVpvMDZheWsiLCJhbGciOiJSUzI1NiIsIng1dCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyIsImtpZCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyJ9.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTAwMDAtYzAwMC0wMDAwMDAwMDAwMDAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC85MGJhZjZmNC1iMmMwLTQyNmMtOTQzMi05OTZiOGUzMTI2NmYvIiwiaWF0IjoxNjkwOTk2NjcxLCJuYmYiOjE2OTA5OTY2NzEsImV4cCI6MTY5MTA4MzM3MSwiYWNjdCI6MCwiYWNyIjoiMSIsImFpbyI6IkFUUUF5LzhVQUFBQUpoS2pXQmRSMEVWV0w4RlJhTWtnN1pueVN2d2NYYjFmUUxpcW5ORk9tbURJa0dkcGZWTjFnMlpDN2t3cDZrcSsiLCJhbXIiOlsicHdkIl0sImFwcF9kaXNwbGF5bmFtZSI6IkdyYXBoIEV4cGxvcmVyIiwiYXBwaWQiOiJkZThiYzhiNS1kOWY5LTQ4YjEtYThhZC1iNzQ4ZGE3MjUwNjQiLCJhcHBpZGFjciI6IjAiLCJmYW1pbHlfbmFtZSI6IkhpbmNhcGnDqSBDYXN0aWxsbyIsImdpdmVuX25hbWUiOiJKb3NlIEFsdmFybyIsImlkdHlwIjoidXNlciIsImlwYWRkciI6IjE4MS4yMzQuMTUyLjI0MyIsIm5hbWUiOiJKb3NlIEFsdmFybyBIaW5jYXBpw6kgQ2FzdGlsbG8iLCJvaWQiOiI2ZTBiMjk2Mi03MGM4LTRhYWItOTJlOS00NzI4MjUyZmQyZGEiLCJwbGF0ZiI6IjMiLCJwdWlkIjoiMTAwMzIwMDFBNTEwQzY1QiIsInJoIjoiMC5BVFFBOVBhNmtNQ3liRUtVTXBscmpqRW1id01BQUFBQUFBQUF3QUFBQUFBQUFBQTBBSlEuIiwic2NwIjoiQ2FsZW5kYXJzLlJlYWQgb3BlbmlkIHByb2ZpbGUgVGFza3MuUmVhZCBUYXNrcy5SZWFkV3JpdGUgVXNlci5SZWFkIGVtYWlsIiwic3ViIjoiUndzT1pCRzZ2enVSUmIzZ2M1ODc4QUhZN0REak1RSDNXZUM4ZkpyMjlZbyIsInRlbmFudF9yZWdpb25fc2NvcGUiOiJTQSIsInRpZCI6IjkwYmFmNmY0LWIyYzAtNDI2Yy05NDMyLTk5NmI4ZTMxMjY2ZiIsInVuaXF1ZV9uYW1lIjoiam9zZS5oaW5jYXBpZUBncnVwb2RpdXNmcmFtaS5jb20uY28iLCJ1cG4iOiJqb3NlLmhpbmNhcGllQGdydXBvZGl1c2ZyYW1pLmNvbS5jbyIsInV0aSI6ImdZNFZpWlNDekVXNnNvUmdGckVSQUEiLCJ2ZXIiOiIxLjAiLCJ3aWRzIjpbImI3OWZiZjRkLTNlZjktNDY4OS04MTQzLTc2YjE5NGU4NTUwOSJdLCJ4bXNfY2MiOlsiQ1AxIl0sInhtc19zc20iOiIxIiwieG1zX3N0Ijp7InN1YiI6IjB6aUcwVXV4ZUlBbGtMSDJuZUZJMTVmMGQ5VnBiS2N6WGl0ZzF6SklDMmcifSwieG1zX3RjZHQiOjE1NjUzODE4Mzl9.mGVpptAUgVc2Iax6uzp3naYAmshoTBsTYVAnjLSjtIiqhWgAYRokWJh4nRzBt5DZa_8Yb8f4WY_sB5xLRkcEKPGtluwkVUMlCRaWqkeXLkWetPsnJ9yiq8-9WEDTe3wzM33P4za7dcbhZ4DWOLRipNTNW9gu5LbcmQ2WBIwIWL6Vhbpy0hOcQ_b-OqHaz4_OqYHDzvKWUCIBswQBsNxCkqEjr_Lk_d4B_nkSYVpu0C_CdDtmKCm9PQOXUc94mLnXUc0zIiyGEf-rCieKDVhPctpmD3oLLOejx2CxFaQjmh90SpGGPIK53Z796dszPamC1hNNRxLGFr4Y5OQQjbsKYA"; 
		
		String url = "https://graph.microsoft.com/v1.0/planner/plans/psoNj7_nvE-DsepK7273HmUACpLv/tasks?api_key=" + token;
		String json = IOUtils.toString(new URL(url));
		// use the reader to read the json to a stream of tokens
		JsonReader reader = new JsonReader(new StringReader(json));
		// we call the handle object method to handle the full json object. This
		// implies that the first token in JsonToken.BEGIN_OBJECT, which is
		// always true.
		handleObject(reader);
	}

	/**
	 * Handle an Object. Consume the first token which is BEGIN_OBJECT. Within
	 * the Object there could be array or non array tokens. We write handler
	 * methods for both. Noe the peek() method. It is used to find out the type
	 * of the next token without actually consuming it.
	 * 
	 * @param reader
	 * @throws IOException
	 */
	private static void handleObject(JsonReader reader) throws IOException
	{
		reader.beginObject();
		while (reader.hasNext()) {
			JsonToken token = reader.peek();
			if (token.equals(JsonToken.BEGIN_ARRAY))
				handleArray(reader);
			else if (token.equals(JsonToken.END_OBJECT)) {
				reader.endObject();
				return;
			} else
				handleNonArrayToken(reader, token);
		}

	}

	/**
	 * Handle a json array. The first token would be JsonToken.BEGIN_ARRAY.
	 * Arrays may contain objects or primitives.
	 * 
	 * @param reader
	 * @throws IOException
	 */
	public static void handleArray(JsonReader reader) throws IOException
	{
		reader.beginArray();
		while (true) {
			JsonToken token = reader.peek();
			if (token.equals(JsonToken.END_ARRAY)) {
				reader.endArray();
				break;
			} else if (token.equals(JsonToken.BEGIN_OBJECT)) {
				handleObject(reader);
			} else if (token.equals(JsonToken.END_OBJECT)) {
				reader.endObject();
			} else
				handleNonArrayToken(reader, token);
		}
	}

	/**
	 * Handle non array non object tokens
	 * 
	 * @param reader
	 * @param token
	 * @throws IOException
	 */
	public static void handleNonArrayToken(JsonReader reader, JsonToken token) throws IOException
	{
		if (token.equals(JsonToken.NAME))
			System.out.println(reader.nextName());
		else if (token.equals(JsonToken.STRING))
			System.out.println(reader.nextString());
		else if (token.equals(JsonToken.NUMBER))
			System.out.println(reader.nextDouble());
		else
			reader.skipValue();
	}
}