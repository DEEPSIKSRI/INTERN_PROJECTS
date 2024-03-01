import { render, screen } from '@testing-library/react';
import App from './App';
import { validateFname} from './LoginForm';
import { validateLname } from './LoginForm';
import { validateEmail } from './LoginForm';
import { validateMobile } from './LoginForm';
// test('renders learn react link', () => {
//   render(<App />);
//   const linkElement = screen.getByText(/learn react/i);
//   expect(linkElement).toBeInTheDocument();
// });


test("FirstName TestCase Pass",()=>
{
  const name="deepsikasri"
  expect(validateFname(name)).toBeTruthy()
})

test("FirstName TestCase Fail",()=>
{
  const name="9"
  expect(validateFname(name)).toBeFalsy()
})

test("Check LastName pass",()=>
{
  const lname="r"
  expect(validateLname(lname)).toBeTruthy()
})
test("check LastName Fail",()=>
{
  const lname="123jjj"
  expect(validateLname(lname)).toBeFalsy()
})
test("Email Pass",()=>
{
  const email="deepsiganesh@gmail.com"
  expect(validateEmail(email)).toBeTruthy()
})
test("Email Fails",()=>
{
  const email="deepsiganesh"
  expect(validateEmail(email)).toBeFalsy()
})

test("MobileNumber Pass",()=>
{
  const mobile="9787744994"
  expect(validateMobile(mobile)).toBeTruthy()
})
test("MobileNumber contains alphabet should not pass Testcase Fails",()=>
{
  const mobile="deepsiganesh"
  expect(validateMobile(mobile)).toBeFalsy()
})
test("MobileNumber contains only 10 digit",()=>
{
  const mobile="1234567890"
  expect(validateMobile(mobile)).toBeTruthy()
})

