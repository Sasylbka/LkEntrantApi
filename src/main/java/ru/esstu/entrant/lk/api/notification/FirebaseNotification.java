package ru.esstu.entrant.lk.api.notification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FirebaseNotification {

    private Collection<String> multicast;
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, Object> notificationAttributes;

    public FirebaseNotification() {
        clearTargets();
        clearAttributes();
    }

    public String toJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        for (String key : requestAttributes.keySet()) {
            objectNode.putPOJO(key, objectMapper.convertValue(requestAttributes.get(key), JsonNode.class));
        }
//		objectNode.putPOJO("notification", objectMapper.convertValue(notificationAttributes, JsonNode.class));
        objectNode.putPOJO("data", objectMapper.convertValue(notificationAttributes, JsonNode.class));
        if (!multicast.isEmpty()) {
            objectNode.putPOJO("registration_ids", multicast);
        }
        return objectNode.toString();
    }

    public void clearTargets() {
        multicast = new ArrayList<>();
    }

    public void clearAttributes() {
        notificationAttributes = new HashMap<>();
        requestAttributes = new HashMap<>();
    }

    public FirebaseNotification addNotificationAttribute(String key, Object value) {
        notificationAttributes.put(key, value);
        return this;
    }

    public FirebaseNotification addRequestAttribute(String key, Object value) {
        requestAttributes.put(key, value);
        return this;
    }

    public FirebaseNotification registration_ids(Collection<String> targets) {
        this.multicast = targets;
        return this;
    }

    public FirebaseNotification addAllMulticasts(Collection<String> targets) {
        this.multicast.addAll(targets);
        return this;
    }

    public FirebaseNotification addMulticast(String target) {
        this.multicast.add(target);
        return this;
    }

    public FirebaseNotification to(String to) {
        return addRequestAttribute("to", to);
    }

    public FirebaseNotification condition(String cond) {
        return addRequestAttribute("condition", cond);
    }

    public FirebaseNotification collapse_key(String key) {
        return addRequestAttribute("collapse_key", key);
    }

    public FirebaseNotification priority(Integer p) {
        p = Math.min(p, 10);
        p = Math.max(p, 0);

        return addRequestAttribute("priority", p);
    }

    public FirebaseNotification delay_while_idle(Boolean b) {
        return addRequestAttribute("delay_while_idle", b);
    }

    public FirebaseNotification time_to_live(Integer n) {
        return addRequestAttribute("time_to_live", n);
    }

    public FirebaseNotification restricted_package_name(String name) {
        return addRequestAttribute("restricted_package_name", name);
    }

    public FirebaseNotification dry_run(Boolean b) {
        return addRequestAttribute("dry_run", b);
    }

    public FirebaseNotification data(Map<String, Object> data) {
        return addRequestAttribute("data", data);
    }

    public FirebaseNotification firebaseNotification(Map<String, Object> map) {
        return addRequestAttribute("notification", map);
    }

    public FirebaseNotification title(String title) {
        return addNotificationAttribute("title", title);
    }

    public FirebaseNotification subtitle(String subtitle) {
        return addNotificationAttribute("subtitle", subtitle);
    }

    public FirebaseNotification body(String body) {
        return addNotificationAttribute("text", body);
    }

    public FirebaseNotification text(String text) {
        return body(text);
    }

    public FirebaseNotification icon(String ic) {
        return addNotificationAttribute("icon", ic);
    }

    public FirebaseNotification sound(String sound) {
        return addNotificationAttribute("sound", sound);
    }

    public FirebaseNotification tag(String tag) {
        return addNotificationAttribute("tag", tag);
    }

    public FirebaseNotification color(String rgb) {
        return addNotificationAttribute("color", rgb);
    }

    public FirebaseNotification click_action(String intent_filter) {
        return addNotificationAttribute("click_action", intent_filter);
    }

    public FirebaseNotification body_loc_key(String key) {
        return addNotificationAttribute("body_loc_key", key);
    }

    public FirebaseNotification body_loc_args(Collection<String> args) {
        return addNotificationAttribute("body_loc_key", args);
    }

    public FirebaseNotification title_loc_key(String key) {
        return addNotificationAttribute("title_loc_key", key);
    }

    public FirebaseNotification title_loc_args(Collection<String> args) {
        return addNotificationAttribute("title_loc_key", args);
    }
}
