#1.

```
public class Users {
    private Integer id;

    private Object email;

    private String encryptedPassword;

    private String resetPasswordToken;

    private Date resetPasswordSentAt;

    private Date rememberCreatedAt;

    private Integer signInCount;

    private Date currentSignInAt;

    private Date lastSignInAt;

    private Object currentSignInIp;

    private Object lastSignInIp;

    private String confirmationToken;

    private Date confirmedAt;

    private Date confirmationSentAt;

    private String unconfirmedEmail;

    private Date createdAt;

    private Date updatedAt;

    private Integer role;

    private String username;

    private String locale;

    private String timeZone;

    private Integer failedAttempts;

    private String unlockToken;

    private Date lockedAt;

    private String encryptedOtpSecret;

    private String encryptedOtpSecretIv;

    private String encryptedOtpSecretSalt;

    private Integer consumedTimestep;

    private Boolean otpRequiredForLogin;

    private Object otpBackupCodes;

    private Date deletedAt;

    private Boolean consentedToShareInformation;

    private Boolean shareInformation;

    private Integer assentlyProvider;

    private String assentlyNationalId;

    private Object ageRange;

    private Integer gender;

    private Long backupEmailId;

    private Boolean patientFlagAlert;

    private Long referredById;

    private Object configuration;

    private String gwenId;

    private String mobileNumber;

    private String stripeCustomerId;

    private Date consentedCookiePolicyAt;

    private String avatar;

    private String fullName;

    private Long companyId;

    private Date therapyInterestedAt;

    private Boolean newsLetterSubscription;
    @NotNull
    private Boolean pushEnabled;
    private String preferredTime;
    private Boolean completedTreatment;
    private String firstName;
    private String lastName;
    private Integer acuityId;
}
```