Feature: Google Cloud Price Calculator
		
	Background: Google Cloud Pricing Calculator is available
	Given I am on the Google Cloud Home Page
	When I search for the "Google Cloud Pricing Calculator"
	And I click on the search results which contains "Google Cloud Pricing Calculator"
	Then the page with the "Google Cloud Pricing Calculator" title opens
		
	@FullScopeWithEmail
	Scenario Outline: Compute Engine Cloud Calculator estimations are correctly sent to an email
		Given I am on the Compute Engine Cloud Calculator tab
		When I fill the number of instances with <Number Of Instances>
		And I select the operating system as <OS>
		And I select the virtual machine class as <VM Class>
		And I select the machine type series as <Machine Type Series>
		And I select the machine type as <Machine Type>
		And I select the <GPU Number> GPUs of type <GPU Type>
		And I select the local SSD as <Local SSD>
		And I select the datacenter location as <Datacenter Location>
		And I select the commited usage as <Commited Usage>
		And I add the combination to the estimate
		And I provide an email for the estimation results to be sent to
		And I choose an option for the estimation results to be sent to an email
		And The email with esimation results arrives
		Then The calculated sum <Estimation Sum> is the same on the page and in the email
		
		Examples:
			| Number Of Instances | OS 					 	 | VM Class 	| Machine Type Series 	| Machine Type  	| GPU Number 	 | GPU Type 				 	 | Local SSD 	 | Datacenter Location 	 | Commited Usage | Estimation Sum |
			| "4"        					| "Free: Debian" | "Regular" 	| "N1" 									| "n1-standard-8" | "1" 				 | "NVIDIA Tesla P100" | "2x375" 		 | "Frankfurt" 					 | "1 Year" 			| "4,024" |
			| "2"        					| "Paid: SLES" 	 | "Regular" 	| "N1"									| "n1-standard-32"| "4" 				 | "NVIDIA Tesla P4" 	 | "7x375" 		 | "Osaka" 					 		 | "3 Years" 			| "3,310" |
			
