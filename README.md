<<<<<<< HEAD
# cde
Covid Data and Exploration
=======
# ubiCov

Brief

Questions Is the uptake of covid vaccinaions impacted in areas with lower income? Have covid cases fallen enough to
safely reopen my business? How has Covid-19 affected businesses in your are? Is the spread of covid-19 in your area
related to nights out? Is low income effecting vaccination uptake. -- Same as above --

## Tech Stack

### Back End

`JAVA SpringBoot JPA Restful Services`

### Front End

`ES6 HTML CSS Material UI ChartJs MapBox Axios`

### Deployment

`MySql AWS S3 AWS S2 - instance`

### React Packages Installed

`npm install --save react-map-gl`
`npm install react-bootstrap bootstrap`
`npm i react-chartjs-2 - npm version`
> > > > > > > Merged multiple Repos into 1 team repo.
> 
> ### Data Sources and Frequency - MVP will cover boroughs of London 


####Covid - Cases Daily
https://coronavirus.data.gov.uk/details/download  chose AreaType  Lower Tier Local Authority Choose Metrics cumCasesByPublishDate
https://api.coronavirus.data.gov.uk/v2/data?areaType=ltla&metric=cumCasesByPublishDate&format=csv

####Covid - Deaths Daily
https://coronavirus.data.gov.uk/details/download  chose AreaType  Lower Tier Local Authority Choose Metrics cumDeathsByPublishDate
https://api.coronavirus.data.gov.uk/v2/data?areaType=ltla&metric=cumDeathsByPublishDate&format=csv


#####Covid - Vaccinations Weekly
https://www.england.nhs.uk/statistics/statistical-work-areas/covid-19-vaccinations/
***Fields used from LTLA tab in weekly csv file - available from website.
Title:	COVID-19 Vaccinations By Lower Tier Local Authority (LTLA) of Residence and Age Group								


####SocioEconomic - Income Deprivation Yearly
look at Overview tab for available fields
https://data-communities.opendata.arcgis.com/datasets/indices-of-multiple-deprivation-imd-2019-1
query for Income Deprivation By Lower Tier Local Authority (LTLA)
https://services3.arcgis.com/ivmBBrHfQfDnDf8Q/arcgis/rest/services/Indices_of_Multiple_Deprivation_(IMD)_2019/FeatureServer/0/query?where=1%3D1&outFields=LADcd,LADnm,IncScore,IncRank,IncDec&outSR=4326&f=json

####SocioEconomic - Furlough Monthly
https://www.gov.uk/government/statistics/coronavirus-job-retention-scheme-statistics-march-2021
Monthly csv file - available from website.
Look at tab 1a. Local Authority Cuml. 
Look at tab 11. Local Authority and gender
Furlough per Business data source - Richard to update
