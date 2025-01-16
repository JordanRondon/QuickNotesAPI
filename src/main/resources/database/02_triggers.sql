CREATE OR REPLACE FUNCTION set_visible_to_true()
RETURNS TRIGGER AS $$
BEGIN
    NEW.visible := TRUE;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER before_insert_set_visible
BEFORE INSERT ON users
FOR EACH ROW
EXECUTE FUNCTION set_visible_to_true();