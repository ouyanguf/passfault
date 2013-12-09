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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//import java.util.Collections;

/**
 * PersonalInfoAnalysis takes personal information from the command line typed
 * by the user and then check whether the information is contained in the
 * password.
 * 
 * This function simulates the case that hacker may also acquire user's personal
 * information from the database in addition to the hashed password. Hackers may
 * want to use these informations as the first guess while cracking the
 * password.
 * 
 * @author ouyanguf
 */

public class PersonalInfoAnalysis {
	String pass;
	String name;
	String phone;
	String email;
	String birth;
	BufferedReader buf_in = new BufferedReader(new InputStreamReader(System.in));

	public PersonalInfoAnalysis(String password) {
		pass = password;
	}

	public void getInfo() throws IOException {
		try {
			System.out.println("Name:");
			name = buf_in.readLine();
			System.out.println("Birthday(e.g.19880930):");
			birth = buf_in.readLine();
			System.out.println("Phone Number(e.g.3527778888):");
			phone = buf_in.readLine();
			System.out.println("Email:");
			email = buf_in.readLine();
		} catch (Exception e) {
			System.out.println("IO exception = " + e);
		}
	}

	public void analyseAll() {
		analyseName();
		analyseBirthday();
		analysePhone();
		analyseEmail();
	}

	public void analyseName() {
		ArrayList<String> cases = new ArrayList<String>();
		cases.add(name);
		cases.add(new StringBuilder(name).reverse().toString());
		cases.add(name.replace('a', '@').replace('s', '$').replace('o', '0'));
		cases.add(name.replace('a', '@'));
		cases.add(name.replace('s', '$'));
		cases.add(name.replace('o', '0'));
		cases.add(new StringBuilder(cases.get(2)).reverse().toString());
		cases.add(new StringBuilder(cases.get(3)).reverse().toString());
		cases.add(new StringBuilder(cases.get(4)).reverse().toString());
		cases.add(new StringBuilder(cases.get(5)).reverse().toString());
		// Collections.addAll(cases, name.split(" "));
		for (String seg : name.split(" ")) {
			cases.add(seg);
			cases.add(new StringBuilder(seg).reverse().toString());
		}

		// Check Cases
		for (String seg : cases) {
			if (pass.contains(seg)) {
				System.out
						.println("Password contains information of your Name!");
				break;
			}
		}

	}

	public void analyseBirthday() {
		ArrayList<String> cases = new ArrayList<String>();
		cases.add(birth); // e.g. 19890812
		cases.add(new StringBuilder(birth).reverse().toString());
		if (birth.length() == 8) {
			cases.add(birth.substring(0, 3)); // e.g. 1989
			cases.add(birth.substring(2, 5)); // e.g. 8908
			cases.add(birth.substring(2, 7)); // e.g. 890812
			cases.add(birth.substring(4, 7)); // e.g. 0812
			cases.add(new StringBuilder(cases.get(2)).reverse().toString());
			cases.add(new StringBuilder(cases.get(3)).reverse().toString());
			cases.add(new StringBuilder(cases.get(4)).reverse().toString());
			cases.add(new StringBuilder(cases.get(5)).reverse().toString());
			// cases.add(new StringBuilder(cases.get(6)).reverse().toString());
		}
		// cases.add(name.replace('a', '@').replace('s', '$').replace('o',
		// '0'));
		// cases.add(name.replace('a', '@'));
		// cases.add(name.replace('s', '$'));
		// cases.add(name.replace('o', '0'));
		// cases.add(new StringBuilder(cases.get(2)).reverse().toString());
		// cases.add(new StringBuilder(cases.get(3)).reverse().toString());
		// cases.add(new StringBuilder(cases.get(4)).reverse().toString());
		// cases.add(new StringBuilder(cases.get(5)).reverse().toString());
		// Collections.addAll(cases, name.split(" "));
		// for (String seg : name.split(" ")) {
		// cases.add(seg);
		// }

		// Check Cases
		for (String seg : cases) {
			if (pass.contains(seg)) {
				System.out
						.println("Password contains information of your Birthday!");
				break;
			}
		}

	}

	public void analysePhone() {
		ArrayList<String> cases = new ArrayList<String>();
		cases.add(phone); // e.g. 3521112222
		cases.add(new StringBuilder(phone).reverse().toString());
		if (phone.length() == 10) {
			cases.add(phone.substring(0, 2)); // e.g. 352
			cases.add(phone.substring(3, 5)); // e.g. 111
			cases.add(phone.substring(6, 9)); // e.g. 2222
			cases.add(phone.substring(0, 5)); // e.g. 352111
			cases.add(phone.substring(3, 9)); // e.g. 1112222
			cases.add(new StringBuilder(cases.get(2)).reverse().toString());
			cases.add(new StringBuilder(cases.get(3)).reverse().toString());
			cases.add(new StringBuilder(cases.get(4)).reverse().toString());
			cases.add(new StringBuilder(cases.get(5)).reverse().toString());
			cases.add(new StringBuilder(cases.get(6)).reverse().toString());
		}
		// cases.add(name.replace('a', '@').replace('s', '$').replace('o',
		// '0'));
		// cases.add(name.replace('a', '@'));
		// cases.add(name.replace('s', '$'));
		cases.add(phone.replace('0', 'o'));
		cases.add(new StringBuilder(cases.get(cases.size() - 1)).reverse()
				.toString());
		// cases.add(new StringBuilder(cases.get(3)).reverse().toString());
		// cases.add(new StringBuilder(cases.get(4)).reverse().toString());
		// cases.add(new StringBuilder(cases.get(5)).reverse().toString());
		// Collections.addAll(cases, name.split(" "));
		// for (String seg : name.split(" ")) {
		// cases.add(seg);
		// }

		// Check Cases
		for (String seg : cases) {
			if (pass.contains(seg)) {
				System.out
						.println("Password contains information about your Phone Number!");
				break;
			}
		}

	}

	public void analyseEmail() {
		ArrayList<String> cases = new ArrayList<String>();
		cases.add(email);
		cases.add(new StringBuilder(email).reverse().toString());
		for (String seg : email.split("@")) {
			cases.add(seg);
			cases.add(new StringBuilder(seg).reverse().toString());
		}
		cases.add(email.replace('a', '@').replace('s', '$').replace('o', '0'));
		cases.add(email.replace('a', '@'));
		cases.add(email.replace('s', '$'));
		cases.add(email.replace('o', '0'));
		// cases.add(new StringBuilder(cases.get(2)).reverse().toString());
		// cases.add(new StringBuilder(cases.get(3)).reverse().toString());
		// cases.add(new StringBuilder(cases.get(4)).reverse().toString());
		// cases.add(new StringBuilder(cases.get(5)).reverse().toString());
		// Collections.addAll(cases, name.split(" "));

		// Check Cases
		for (String seg : cases) {
			if (pass.contains(seg)) {
				System.out
						.println("Password contains information of your Email!");
				break;
			}
		}

	}

	public void run() throws IOException {
		getInfo();
		analyseAll();

	}

	//public static void main(String[] args) throws IOException {
		//PersonalInfoAnalysis crackInfo = new PersonalInfoAnalysis("asd1387weoi");
		//crackInfo.run();
	//}
}