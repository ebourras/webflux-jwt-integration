package com.deliveryapp.delivery.security;

import java.util.Set;

record ProfileResponse(String username, Set<String> roles) {
}
