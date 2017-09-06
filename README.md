# spring-data-rest-projection-resource-processor
Demo showcasing issue with missing custom links provided by ResourceProcessor while running Projection

I created simple sample Spring Data REST based web app which has `CountryCriterion` and `Country` entities (hence SDR exporter exports countryCriteria and countries resources)

I also created `CountryCriterionResourceProcessor` which should add `edit` link, even if you use projection to transform resulting HAL response 

In order to reproduce the issue, do the following:

Run boot application

Follow http://localhost:8080/browser/index.html#http://localhost:8080/countryCriteria
in HAL browser you can find `edit` rel in Links section

Follow http://localhost:8080/browser/index.html#http://localhost:8080/countryCriteria/1?projection=withCountries
in HAL browser you **can't** find `edit` rel in Links section
