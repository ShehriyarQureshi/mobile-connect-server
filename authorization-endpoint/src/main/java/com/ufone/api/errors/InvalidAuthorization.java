/*
 * Copyright (c) 2019 Muhammad Shehriyar Qureshi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package com.ufone.api.errors;

import com.ufone.api.errors.BaseErrorResponse;
import com.ufone.api.request.AuthorizationServerRequest;

import javax.ws.rs.core.Response;

import java.io.UnsupportedEncodingException;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class InvalidAuthorization {
        private final String error = "invalid_request";
        private final String errorDescription =
            "Authorization Header is not Basic or in the wrong format";

        public String getErrorTitle() {
                return this.error;
        }

        public String getErrorDescription() {
                return this.errorDescription;
        }

        public Response returnResponse(String jsonResponse) {
                return Response.status(302).entity(jsonResponse).build();
        }

        public Response buildAndReturnResponse() {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonResponse = gson.toJson(new InvalidAuthorization());
                return this.returnResponse(jsonResponse);
        }
}
