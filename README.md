# Space Launch Info
A Java application that fetches and displays upcoming space launch details from the SpaceDevs API. The app uses asynchronous programming to fetch data, and parses the JSON response using Gson.

## Features
- Fetches data from the SpaceDevs API
- Asynchronous HTTP requests with `CompletableFuture`
- JSON parsing with Gson
- Displays launch details (name, status, description, window times)

## Technologies
- Java 11+
- Gson (for JSON parsing)
- `CompletableFuture` (for asynchronous processing)
- SpaceDevs API (public API for upcoming space launches)

## Example Output
```
Falcon 9 Block 5 | Starlink Group 6-66
 - Status: To Be Confirmed
 - Description: Awaiting official confirmation - current date is known with some certainty.
 - Window Start (UTC): 2024-11-21 - 15:53
 - Window End (UTC): 2024-11-21 - 19:53
```

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
