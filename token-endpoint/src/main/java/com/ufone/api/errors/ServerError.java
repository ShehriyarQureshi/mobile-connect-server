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
import com.ufone.api.request.TokenEndpointRequest;

import javax.ws.rs.core.Response;

import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class ServerError {
        @SerializedName("error") private final String error = "server_error";
        @SerializedName("error_description")
        private final String errorDescription = "Internal Server Error";

        public String getErrorTitle() {
                return this.error;
        }

        public String getErrorDescription() {
                return this.errorDescription;
        }

        public Response buildAndReturnResponse() throws UnsupportedEncodingException {
                ServerError errorResponse = new ServerError();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonResponse = gson.toJson(errorResponse);
                return Response.status(400).entity(jsonResponse).build();
        }
}
