**Test Cases for Login Functionality**

**1. Verification of Input Fields:**

* **Precondition:** The application is launched.
* **Steps:**
    * Locate the username and password input fields on the main screen.
    * Verify that the username input field has an ID equal to "user-name".
    * Verify that the password input field has an ID equal to "password".
    * Verify that the login button has an ID equal to "login-button".
* **Expected Result:** The input fields are present and correctly identified.

**2. Successful Login:**

* **Precondition:** The user has entered valid credentials (Username: standard_user, Password: secret_sauce).
* **Steps:**
    * Click the login button.
* **Expected Result:** The user is successfully logged in, and a div containing the text "Swag Labs" becomes visible on the screen.

**3. Unsuccessful Login with Invalid Credentials:**

**Precondition:** The user has entered invalid credentials.
* **Steps:**
    * Click the login button.
**Expected Result:** An error message is displayed within a div with the class "error-message-container error". The message should indicate that the username and password do not match any existing user.

**4. Validation of Required Fields:**

* **Precondition:** The user has left one field empty.
* **Steps:**
    * Click the login button.
* **Expected Result:** An error message is displayed within a div with the class "error-message-container error". The message should indicate that the missing field (username or password) is required.
