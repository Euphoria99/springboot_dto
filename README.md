
# Springboot-DTO Pattern

Learning DTO pattern of Springboot



## Directories

part-1 : Springboot DTO pattern using Records and Mappers

part-2 : Springboot DTO pattern using Pojos and Mapper(Java 8 style without records)



### Workflow

1) Controller -> POJO:

The controller receives the request and maps it to a POJO for validation.

2) POJO -> DTO:

The POJO is mapped to a DTO.

The POJO handles validation of fields.

3) DTO -> Entity:

The DTO is mapped to an Entity, which is saved to the database.

The DTO here has some extra fields(like date,modified date etc) that we generally dont take from user.

4) Service -> Repository -> DB:

The service layer uses the repository to save the Entity to the database.

5) Repository -> Service -> DTO:

When fetching data, the repository retrieves the Entity, which is then mapped to a response DTO.

6) DTO -> Response POJO:

The response DTO is mapped to a response POJO, which is returned to the client.

*The mapper class handles mapping of data between POJO, DTO and Entity*


To create random dates between two date ranges

```
Random random = new Random();
LocalDate startDate = LocalDate.of(2024, Month.JUNE, 1);
LocalDate endDate = LocalDate.of(2024, Month.AUGUST, 1);
long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
long randomDays = random.nextInt((int) daysBetween + 1);
LocalDateTime randomCreatedAt = startDate.atStartOfDay().plusDays(randomDays);
```

