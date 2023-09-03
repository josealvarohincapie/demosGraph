package com.studytrails.json.gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {


public static void main(String[] args) throws Exception {

    // Sending get request
    URL url = new URL("https://graph.microsoft.com/v1.0/planner/plans/psoNj7_nvE-DsepK7273HmUACpLv/tasks");
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJub25jZSI6InU1TUNuRW1UYlZFUWNHd1J0dXJwNUZQekpOZ05lMXN2Sk95UVpvMDZheWsiLCJhbGciOiJSUzI1NiIsIng1dCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyIsImtpZCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyJ9.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTAwMDAtYzAwMC0wMDAwMDAwMDAwMDAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC85MGJhZjZmNC1iMmMwLTQyNmMtOTQzMi05OTZiOGUzMTI2NmYvIiwiaWF0IjoxNjkwOTk2NjcxLCJuYmYiOjE2OTA5OTY2NzEsImV4cCI6MTY5MTA4MzM3MSwiYWNjdCI6MCwiYWNyIjoiMSIsImFpbyI6IkFUUUF5LzhVQUFBQUpoS2pXQmRSMEVWV0w4RlJhTWtnN1pueVN2d2NYYjFmUUxpcW5ORk9tbURJa0dkcGZWTjFnMlpDN2t3cDZrcSsiLCJhbXIiOlsicHdkIl0sImFwcF9kaXNwbGF5bmFtZSI6IkdyYXBoIEV4cGxvcmVyIiwiYXBwaWQiOiJkZThiYzhiNS1kOWY5LTQ4YjEtYThhZC1iNzQ4ZGE3MjUwNjQiLCJhcHBpZGFjciI6IjAiLCJmYW1pbHlfbmFtZSI6IkhpbmNhcGnDqSBDYXN0aWxsbyIsImdpdmVuX25hbWUiOiJKb3NlIEFsdmFybyIsImlkdHlwIjoidXNlciIsImlwYWRkciI6IjE4MS4yMzQuMTUyLjI0MyIsIm5hbWUiOiJKb3NlIEFsdmFybyBIaW5jYXBpw6kgQ2FzdGlsbG8iLCJvaWQiOiI2ZTBiMjk2Mi03MGM4LTRhYWItOTJlOS00NzI4MjUyZmQyZGEiLCJwbGF0ZiI6IjMiLCJwdWlkIjoiMTAwMzIwMDFBNTEwQzY1QiIsInJoIjoiMC5BVFFBOVBhNmtNQ3liRUtVTXBscmpqRW1id01BQUFBQUFBQUF3QUFBQUFBQUFBQTBBSlEuIiwic2NwIjoiQ2FsZW5kYXJzLlJlYWQgb3BlbmlkIHByb2ZpbGUgVGFza3MuUmVhZCBUYXNrcy5SZWFkV3JpdGUgVXNlci5SZWFkIGVtYWlsIiwic3ViIjoiUndzT1pCRzZ2enVSUmIzZ2M1ODc4QUhZN0REak1RSDNXZUM4ZkpyMjlZbyIsInRlbmFudF9yZWdpb25fc2NvcGUiOiJTQSIsInRpZCI6IjkwYmFmNmY0LWIyYzAtNDI2Yy05NDMyLTk5NmI4ZTMxMjY2ZiIsInVuaXF1ZV9uYW1lIjoiam9zZS5oaW5jYXBpZUBncnVwb2RpdXNmcmFtaS5jb20uY28iLCJ1cG4iOiJqb3NlLmhpbmNhcGllQGdydXBvZGl1c2ZyYW1pLmNvbS5jbyIsInV0aSI6ImdZNFZpWlNDekVXNnNvUmdGckVSQUEiLCJ2ZXIiOiIxLjAiLCJ3aWRzIjpbImI3OWZiZjRkLTNlZjktNDY4OS04MTQzLTc2YjE5NGU4NTUwOSJdLCJ4bXNfY2MiOlsiQ1AxIl0sInhtc19zc20iOiIxIiwieG1zX3N0Ijp7InN1YiI6IjB6aUcwVXV4ZUlBbGtMSDJuZUZJMTVmMGQ5VnBiS2N6WGl0ZzF6SklDMmcifSwieG1zX3RjZHQiOjE1NjUzODE4Mzl9.mGVpptAUgVc2Iax6uzp3naYAmshoTBsTYVAnjLSjtIiqhWgAYRokWJh4nRzBt5DZa_8Yb8f4WY_sB5xLRkcEKPGtluwkVUMlCRaWqkeXLkWetPsnJ9yiq8-9WEDTe3wzM33P4za7dcbhZ4DWOLRipNTNW9gu5LbcmQ2WBIwIWL6Vhbpy0hOcQ_b-OqHaz4_OqYHDzvKWUCIBswQBsNxCkqEjr_Lk_d4B_nkSYVpu0C_CdDtmKCm9PQOXUc94mLnXUc0zIiyGEf-rCieKDVhPctpmD3oLLOejx2CxFaQjmh90SpGGPIK53Z796dszPamC1hNNRxLGFr4Y5OQQjbsKYA"; 
	
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestProperty("Accept", "application/json");
    conn.setRequestProperty("Authorization",token);
    
    //e.g. bearer token= eyJhbGciOiXXXzUxMiJ9.eyJzdWIiOiPyc2hhcm1hQHBsdW1zbGljZS5jb206OjE6OjkwIiwiZXhwIjoxNTM3MzQyNTIxLCJpYXQiOjE1MzY3Mzc3MjF9.O33zP2l_0eDNfcqSQz29jUGJC-_THYsXllrmkFnk85dNRbAw66dyEKBP5dVcFUuNTA8zhA83kk3Y41_qZYx43T

    conn.setRequestProperty("Content-Type","application/json");
    
   conn.setRequestMethod("GET");
    
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String output;

    StringBuffer response = new StringBuffer();
   
    
    while ((output = in.readLine()) != null) {
        System.out.println("Response:-" + output.toString());
////you will get output in "output.toString()" ,Use it however you like
    }
    in.close();
    
}
}