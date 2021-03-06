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
package com.ufone.api.request;

/*
 * This class is to be used to hold the request parameters sent from the client.
 * It is aimed to make it easier to pass around the request's query parameters.
 *
 * It uses the builder pattern. Though there is no strong use case for it, I'm using it in case
 * query parameters change.
 */
public class AuthorizationServerRequest {
        // Required parameters
        private String clientID;
        private String redirectURI;
        private String responseType;
        private String scope;
        private String version;
        private String state;
        private String nonce;

        // Optional parameters
        private String display;
        private String prompt;
        private String maxAge;
        private String uiLocales;
        private String claimsLocales;
        private String idTokenHint;
        private String loginHint;
        private String loginHintToken;
        private String acrValues;
        private String responseMode;
        private String correlationID;
        private String dtbs;

        // Getters
        public String getClientID() {
                return this.clientID;
        }

        public String getRedirectURI() {
                return this.redirectURI;
        }

        public String getResponseType() {
                return this.responseType;
        }

        public String getScope() {
                return this.scope;
        }

        public String getVersion() {
                return this.version;
        }

        public String getState() {
                return this.state;
        }

        public String getNonce() {
                return this.nonce;
        }

        public String getDisplay() {
                return this.display;
        }

        public String getPrompt() {
                return this.prompt;
        }

        public String getMaxAge() {
                return this.maxAge;
        }

        public String getUiLocales() {
                return this.uiLocales;
        }

        public String getClaimsLocales() {
                return this.claimsLocales;
        }

        public String getIdTokenHint() {
                return this.idTokenHint;
        }

        public String getLoginHint() {
                return this.loginHint;
        }

        public String getLoginHintToken() {
                return this.loginHintToken;
        }

        public String getAcrValues() {
                return this.acrValues;
        }

        public String getResponseMode() {
                return this.responseMode;
        }

        public String getCorrelationID() {
                return this.correlationID;
        }

        public String getDtbs() {
                return this.dtbs;
        }

        // Setters
        public AuthorizationServerRequest display(String display) {
                this.display = display;
                return this;
        }

        public AuthorizationServerRequest prompt(String prompt) {
                this.prompt = prompt;
                return this;
        }

        public AuthorizationServerRequest maxAge(String maxAge) {
                this.maxAge = maxAge;
                return this;
        }

        public AuthorizationServerRequest uiLocales(String uiLocales) {
                this.uiLocales = uiLocales;
                return this;
        }

        public AuthorizationServerRequest claimsLocales(String claimsLocales) {
                this.claimsLocales = claimsLocales;
                return this;
        }

        public AuthorizationServerRequest idTokenHint(String idTokenHint) {
                this.idTokenHint = idTokenHint;
                return this;
        }

        public AuthorizationServerRequest loginHint(String loginHint) {
                this.loginHint = loginHint;
                return this;
        }

        public AuthorizationServerRequest loginHintToken(String loginHintToken) {
                this.loginHintToken = loginHintToken;
                return this;
        }

        public AuthorizationServerRequest acrValues(String acrValues) {
                this.acrValues = acrValues;
                return this;
        }

        public AuthorizationServerRequest responseMode(String responseMode) {
                this.responseMode = responseMode;
                return this;
        }

        public AuthorizationServerRequest correlationID(String correlationID) {
                this.correlationID = correlationID;
                return this;
        }

        public AuthorizationServerRequest dtbs(String dtbs) {
                this.dtbs = dtbs;
                return this;
        }

        public AuthorizationServerRequest(String clientID, String redirectURI, String responseType,
            String scope, String version, String state, String nonce) {
                this.clientID = clientID;
                this.redirectURI = redirectURI;
                this.responseType = responseType;
                this.scope = scope;
                this.version = version;
                this.state = state;
                this.nonce = nonce;
        }

        public AuthorizationServerRequest build() {
                AuthorizationServerRequest request = new AuthorizationServerRequest(
                    clientID, redirectURI, responseType, scope, version, state, nonce);
                request.display = this.display;
                request.prompt = this.prompt;
                request.maxAge = this.maxAge;
                request.uiLocales = this.uiLocales;
                request.claimsLocales = this.claimsLocales;
                request.idTokenHint = this.idTokenHint;
                request.loginHint = this.loginHint;
                request.loginHintToken = this.loginHintToken;
                request.acrValues = this.acrValues;
                request.responseMode = this.responseMode;
                request.correlationID = this.correlationID;
                request.dtbs = this.dtbs;
                return request;
        }
}
