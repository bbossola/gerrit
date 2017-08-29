import static java.util.stream.Collectors.toList;
import com.google.common.collect.ImmutableList;
import com.google.gerrit.server.notedb.NotesMigration;
import com.google.gerrit.server.notedb.ReviewerStateInternal;
import java.util.Arrays;
import java.util.stream.Stream;
  private final NotesMigration notesMigration;
      NotesMigration notesMigration,
        notesMigration,
      NotesMigration notesMigration,
        notesMigration,
      NotesMigration notesMigration,
        notesMigration,
      NotesMigration notesMigration,
    this(
        notesFactory,
        approvalsUtil,
        queryProvider,
        notesMigration,
        db,
        i,
        testRepo,
        subject,
        files,
        null);
      NotesMigration notesMigration,
        notesMigration,
      NotesMigration notesMigration,
    this.notesMigration = notesMigration;
  public void setTag(Tag tag) {
      assertChange(
          expectedStatus, expectedTopic, Arrays.asList(expectedReviewers), ImmutableList.of());
    }

    public void assertChange(
        Change.Status expectedStatus,
        String expectedTopic,
        List<TestAccount> expectedReviewers,
        List<TestAccount> expectedCcs)
        throws OrmException {
      if (notesMigration.readChanges()) {
        assertReviewers(c, ReviewerStateInternal.REVIEWER, expectedReviewers);
        assertReviewers(c, ReviewerStateInternal.CC, expectedCcs);
      } else {
        assertReviewers(
            c,
            ReviewerStateInternal.REVIEWER,
            Stream.concat(expectedReviewers.stream(), expectedCcs.stream()).collect(toList()));
      }
    private void assertReviewers(
        Change c, ReviewerStateInternal state, List<TestAccount> expectedReviewers)
        throws OrmException {
          approvalsUtil.getReviewers(db, notesFactory.createChecked(db, c)).byState(state);