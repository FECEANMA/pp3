-- Corregir el tipo de datos de la columna 'phone'
ALTER TABLE users
ALTER COLUMN phone TYPE VARCHAR(15);  -- Cambiar el tipo a VARCHAR o el tipo que necesites
