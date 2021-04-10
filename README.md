<<<<<<< HEAD
# cde
Covid Data and Exploration
=======
# ubiCov

#Brief
Create a web app that enables users to explore the relationship between Covid-19 cases and socio economic factors
https://classroom.google.com/c/NTg1MTgxODU0Mjda/m/Mjk3NzI0MzQxMzUx/details
#Questions
Is the uptake of covid vaccinations impacted in areas with lower income? 
Have covid cases fallen enough to safely reopen my business? How has Covid-19 affected businesses in your area? 
Is the spread of covid-19 in your area related to nights out? Is low income effecting vaccination uptake. 
MVP will cover boroughs of London.
#Future releases  
- drilling into borough level data
- zooming out to larger regions
- automation of data extraction from sources
- autodetect viewers region to default map display



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

#Future tech stack
Spring Cloud or Micronaut 
AWS Lamda

 ### Data Sources and Frequency - MVP will cover boroughs of London 

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


####SocioEconomic - Income Deprivation Every 3-4 years latest 2019
London Data
https://data.london.gov.uk/dataset/indices-of-deprivation
csv - Look for tab Borough IDACI IDAOPI
https://data.london.gov.uk/download/indices-of-deprivation/9ee0cf66-e6f9-4e38-8eec-79c1d897e248/ID%202019%20for%20London.xlsx

National Data by Lower Tier Local Authority (LTLA)
https://assets.publishing.service.gov.uk/government/uploads/system/uploads/attachment_data/file/835115/IoD2019_Statistical_Release.pdf
https://www.gov.uk/government/statistics/english-indices-of-deprivation-2019 Look at File 10: local authority district summaries

Further - Deprivation GeoSpatial data
look at Overview tab for available fields
https://data-communities.opendata.arcgis.com/datasets/indices-of-multiple-deprivation-imd-2019-1
look at API Explorer tab for building query 
query for Income Deprivation By Lower Tier Local Authority (LTLA)
https://services3.arcgis.com/ivmBBrHfQfDnDf8Q/arcgis/rest/services/Indices_of_Multiple_Deprivation_(IMD)_2019/FeatureServer/0/query?where=1%3D1&outFields=LADcd,LADnm,IncScore,IncRank,IncDec&outSR=4326&f=json

####SocioEconomic - Furlough Monthly
https://www.gov.uk/government/statistics/coronavirus-job-retention-scheme-statistics-march-2021
Monthly csv file - available from website.
Look at tab 1a. Local Authority Cuml. 
Look at tab 11. Local Authority and gender
Furlough per Business data source - Richard to update

#Other Sources to Research
https://data.london.gov.uk/dataset/socio-economic-impact-of-covid-19
