Feature:login
Scenario outline:validate userid
Given lanuch gmailsite
When enter userid as "<x>"
And click next button
Then validate userid with "<y>"
And close site

data driven:
|x|y|
|vaddegopi5@gmail.com|valid|
|vaddegopi567@gmail.com|invalid|
|                 |invalid|
