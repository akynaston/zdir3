import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AWSSample {
    private static final Map<String, String> AWS_VALUE_CACHE = new HashMap<>();
    private static final Map<String, AtomicInteger> AWS_CACHE_HITS = new HashMap<>();

    public static void main(String[] args) {

    }

    public static String getAWSValue(String key, boolean caching) throws Exception {
        String[] split = key.split(":");
        if (split.length != 2) {
            throw new Exception("AWS Key passed in must be in format aws:keyname, e.g.: aws:dev/MiroSCIM_BearerToken");
        }
        String secretName = split[1];

        if (caching) {
            if (AWS_VALUE_CACHE.containsKey(secretName)) {
                AWS_CACHE_HITS.computeIfAbsent(secretName, a -> new AtomicInteger()).incrementAndGet();
            } else {
                String value = getSecretFromAWS(secretName);
                AWS_VALUE_CACHE.put(secretName, value);
            }
            return AWS_VALUE_CACHE.get(secretName);
        } else {
            return getSecretFromAWS(secretName);
        }
    }

    /**
     * The getValue and getSecretFromAWS functions were copied from AWSResolver in the swa-idm-unit project.
     *
     * @param secretName
     * @return
     */
    private static String getSecretFromAWS(String secretName) {
        Region region = Region.of(System.getenv().getOrDefault("AWS_DEFAULT_REGION", "us-east-1"));

        // Create a Secrets Manager client
        try (SecretsManagerClient client = SecretsManagerClient.builder()
                .region(region)
                .build()) {


            GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                    .secretId(secretName)
                    .build();

            GetSecretValueResponse getSecretValueResponse;


            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
            return getSecretValueResponse.secretString();

        } catch (SdkException e) {
            // For a list of exceptions thrown, see
            // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
            throw e;
        }
    }

}


