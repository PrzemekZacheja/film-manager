# Film Manager Application

This project is a Spring Boot application for managing films. The application uses an external API
OMDB https://www.omdbapi.com/
Videos marked as favorites are saved to a PostgreSQL database on Docker

## Functionality:

1. **Video Search:**
2. **Adding a video to your favorites:**
3. **View your favorite videos:**

### Features: Search films by title and mark them as favourite

Copy git clone https://github.com/your_username/film-manager.git

The application will be running at http://localhost:8080

#### REST API doc from SWAGGER:
{
    "openapi": "3.0.1",
    "info": {
        "title": "OpenAPI definition",
        "version": "v0"
    },
    "servers": [
        {
            "url": "http://localhost:8080",
            "description": "Generated server url"
        }
    ],
    "paths": {
        "/films": {
            "get": {
                "tags": [
                    "film-controller"
                ],
                "operationId": "getAllFavouriteFilms",
                "responses": {
                    "200": {
                        "description": "OK",
                        "content": {
                            "*/*": {
                                "schema": {
                                    "type": "array",
                                    "items": {
                                        "$ref": "#/components/schemas/FilmResponseDto"
                                    }
                                }
                            }
                        }
                    },
                    "404": {
                        "description": "Not Found",
                        "content": {
                            "*/*": {
                                "schema": {
                                    "$ref": "#/components/schemas/FilmErrorResponseDto"
                                }
                            }
                        }
                    },
                    "409": {
                        "description": "Conflict",
                        "content": {
                            "*/*": {
                                "schema": {
                                    "$ref": "#/components/schemas/FilmErrorResponseDto"
                                }
                            }
                        }
                    }
                }
            }
        },
        "/film/{title}": {
            "get": {
                "tags": [
                    "film-controller"
                ],
                "operationId": "getFilmByTitle",
                "parameters": [
                    {
                        "name": "title",
                        "in": "path",
                        "required": true,
                        "schema": {
                            "type": "string"
                        }
                    },
                    {
                        "name": "favorite",
                        "in": "header",
                        "required": false,
                        "schema": {
                            "type": "boolean"
                        }
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "content": {
                            "*/*": {
                                "schema": {
                                    "$ref": "#/components/schemas/FilmResponseDto"
                                }
                            }
                        }
                    },
                    "404": {
                        "description": "Not Found",
                        "content": {
                            "*/*": {
                                "schema": {
                                    "$ref": "#/components/schemas/FilmErrorResponseDto"
                                }
                            }
                        }
                    },
                    "409": {
                        "description": "Conflict",
                        "content": {
                            "*/*": {
                                "schema": {
                                    "$ref": "#/components/schemas/FilmErrorResponseDto"
                                }
                            }
                        }
                    }
                }
            }
        }
    },
    "components": {
        "schemas": {
            "FilmErrorResponseDto": {
                "type": "object",
                "properties": {
                    "message": {
                        "type": "string"
                    },
                    "httpStatus": {
                        "type": "string",
                        "enum": [
                            "100 CONTINUE",
                            "101 SWITCHING_PROTOCOLS",
                            "102 PROCESSING",
                            "103 EARLY_HINTS",
                            "103 CHECKPOINT",
                            "200 OK",
                            "201 CREATED",
                            "202 ACCEPTED",
                            "203 NON_AUTHORITATIVE_INFORMATION",
                            "204 NO_CONTENT",
                            "205 RESET_CONTENT",
                            "206 PARTIAL_CONTENT",
                            "207 MULTI_STATUS",
                            "208 ALREADY_REPORTED",
                            "226 IM_USED",
                            "300 MULTIPLE_CHOICES",
                            "301 MOVED_PERMANENTLY",
                            "302 FOUND",
                            "302 MOVED_TEMPORARILY",
                            "303 SEE_OTHER",
                            "304 NOT_MODIFIED",
                            "305 USE_PROXY",
                            "307 TEMPORARY_REDIRECT",
                            "308 PERMANENT_REDIRECT",
                            "400 BAD_REQUEST",
                            "401 UNAUTHORIZED",
                            "402 PAYMENT_REQUIRED",
                            "403 FORBIDDEN",
                            "404 NOT_FOUND",
                            "405 METHOD_NOT_ALLOWED",
                            "406 NOT_ACCEPTABLE",
                            "407 PROXY_AUTHENTICATION_REQUIRED",
                            "408 REQUEST_TIMEOUT",
                            "409 CONFLICT",
                            "410 GONE",
                            "411 LENGTH_REQUIRED",
                            "412 PRECONDITION_FAILED",
                            "413 PAYLOAD_TOO_LARGE",
                            "413 REQUEST_ENTITY_TOO_LARGE",
                            "414 URI_TOO_LONG",
                            "414 REQUEST_URI_TOO_LONG",
                            "415 UNSUPPORTED_MEDIA_TYPE",
                            "416 REQUESTED_RANGE_NOT_SATISFIABLE",
                            "417 EXPECTATION_FAILED",
                            "418 I_AM_A_TEAPOT",
                            "419 INSUFFICIENT_SPACE_ON_RESOURCE",
                            "420 METHOD_FAILURE",
                            "421 DESTINATION_LOCKED",
                            "422 UNPROCESSABLE_ENTITY",
                            "423 LOCKED",
                            "424 FAILED_DEPENDENCY",
                            "425 TOO_EARLY",
                            "426 UPGRADE_REQUIRED",
                            "428 PRECONDITION_REQUIRED",
                            "429 TOO_MANY_REQUESTS",
                            "431 REQUEST_HEADER_FIELDS_TOO_LARGE",
                            "451 UNAVAILABLE_FOR_LEGAL_REASONS",
                            "500 INTERNAL_SERVER_ERROR",
                            "501 NOT_IMPLEMENTED",
                            "502 BAD_GATEWAY",
                            "503 SERVICE_UNAVAILABLE",
                            "504 GATEWAY_TIMEOUT",
                            "505 HTTP_VERSION_NOT_SUPPORTED",
                            "506 VARIANT_ALSO_NEGOTIATES",
                            "507 INSUFFICIENT_STORAGE",
                            "508 LOOP_DETECTED",
                            "509 BANDWIDTH_LIMIT_EXCEEDED",
                            "510 NOT_EXTENDED",
                            "511 NETWORK_AUTHENTICATION_REQUIRED"
                        ]
                    }
                }
            },
            "FilmResponseDto": {
                "type": "object",
                "properties": {
                    "Title": {
                        "type": "string"
                    },
                    "Plot": {
                        "type": "string"
                    },
                    "Genre": {
                        "type": "string"
                    },
                    "Director": {
                        "type": "string"
                    },
                    "Poster": {
                        "type": "string"
                    }
                }
            }
        }
    }
}

TODOs

1. Add integration tests
2. implementing Paging and Sorting