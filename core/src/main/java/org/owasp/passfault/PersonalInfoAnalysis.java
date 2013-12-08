/* Copyright 2013 Yang Ou
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.owasp.passfault;

/**
 * PersonalInfoAnalysis takes personal information from the command line
 * typed by the user and then check whether the information is contained
 * in the password.
 *
 * This function simulates the case that hacker may also acquire user's
 * personal information from the database in addition to the hashed
 * password. Hackers may want to use these informations as the first
 * guess while cracking the password.
 * @author ouyanguf
 */
 
 public class PersonalInfoAnalysis {
   
   public void run() {
     System.out.println("aa");
   }
 }