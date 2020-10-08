Feature: Adding and Searching feature

Scenario: Adding a category and Searching for it
Given User navigates to "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User types in "admin@yourstore.com" as username
And User types in "admin" as password
When User clicks on Log In Button
Then User should be moved to "https://admin-demo.nopcommerce.com/admin/"
When User clicks on Catalog Menu
And User clicks on Category Submenu
Then He is directed to "https://admin-demo.nopcommerce.com/Admin/Category/List"
When User clicks on Add New Button
Then User is directed to "https://admin-demo.nopcommerce.com/Admin/Category/Create"
When User types Name as "Socks",selects Parent Category and clicks on Save
Then User is moved to "https://admin-demo.nopcommerce.com/Admin/Category/List"
And User is able to get the relevant Information Bar
When User searches for "apparel" and clicks on Search Button
Then User gets a matching result Set for "Apparel"

   