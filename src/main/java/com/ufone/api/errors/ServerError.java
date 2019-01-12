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
import com.ufone.api.request.TokenEndpointRequest;

import javax.ws.rs.core.Response;

import java.io.UnsupportedEncodingException;

public class ServerError extends BaseErrorResponse {
        private final String error = "server_error";
        private final String errorDescription = "Internal Server Error";
        private String baseResponse;

        @Override
        public String getErrorTitle() {
                return this.error;
        }

        @Override
        public String getErrorDescription() {
                return this.errorDescription;
        }

        public Response buildAndReturnResponse(AuthorizationServerRequest request)
            throws UnsupportedEncodingException {
                ServerError errorResponse = new ServerError();
                baseResponse = errorResponse.buildBaseErrorResponse(request.getRedirectURI());
                baseResponse = errorResponse.addStateQueryParam(baseResponse, request.getState());
                baseResponse = errorResponse.addCorrelationIDQueryParam(
                    baseResponse, request.getCorrelationID());
                return errorResponse.returnResponse(baseResponse);
        }

        public Response buildAndReturnResponse(TokenEndpointRequest request)
            throws UnsupportedEncodingException {
                ServerError errorResponse = new ServerError();
                baseResponse = errorResponse.buildBaseErrorResponse(request.getRedirectURI());
                baseResponse = errorResponse.addCorrelationIDQueryParam(
                    baseResponse, request.getCorrelationID());
                return errorResponse.returnResponse(baseResponse);
        }
}
