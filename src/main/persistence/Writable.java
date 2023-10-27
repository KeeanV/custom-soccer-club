package persistence;

import org.json.JSONObject;

// copied from JsonSerializationDemo provided on GitHub
public interface Writable {
    JSONObject toJson();
}
