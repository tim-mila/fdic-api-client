# FDIC Bank Data API CLIent

Stand-alone client library to interact with the Bank Data API provided by FDIC, [FDIC Bank Data API](https://banks.data.fdic.gov/docs/).

Example usage:
```Java
new FdicClient().query(
    FdicQuery
    .from(Endpoint.Institution)
    .filter(Filter.and(Filter.value("NAME", "Wells*"), Filter.value("ACTIVE", "1")))
    .field("NAME")
    .field("ZIP")
    .sortBy("OFFICES")
    .sortOrder(FdicQuery.SortOrder.ASC)
    );
```